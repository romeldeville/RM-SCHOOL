package rmschoolapi.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Gestion centralisée des exceptions de l'application.
 *
 * Toutes les réponses d'erreur sont normalisées en {@link ReponseErreur} :
 * - les {@link BusinessException} sont mappées sur le statut porté par leur {@link ErrorCode} ;
 * - les erreurs de validation (Bean Validation / lecture de corps / types de paramètres)
 *   sont traduites en 400 avec le détail par champ ;
 * - toute autre exception non anticipée est capturée et traduite en 500 sans fuiter
 *   d'information interne au client.
 */
@Slf4j
@RestControllerAdvice
public class GestionnaireExceptionsGlobal {

    // ------------------------------------------------------------------ //
    //  Exceptions métier                                                  //
    // ------------------------------------------------------------------ //

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ReponseErreur> gererBusinessException(BusinessException ex, HttpServletRequest request) {
        log.warn("Exception métier [{}] sur {}", ex.getCode().name(), request.getRequestURI(), ex);
        return construire(ex.getStatut(), ex.getCode(), ex.getMessage(), request, null);
    }

    // ------------------------------------------------------------------ //
    //  Validation & paramètres de requête                                 //
    // ------------------------------------------------------------------ //

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ReponseErreur> gererValidation(MethodArgumentNotValidException ex, HttpServletRequest request) {
        Map<String, String> erreurs = new LinkedHashMap<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            erreurs.putIfAbsent(fieldError.getField(), fieldError.getDefaultMessage());
        }
        log.warn("Validation échouée sur {} : {}", request.getRequestURI(), erreurs);
        return construire(HttpStatus.BAD_REQUEST, ErrorCode.DONNEES_INVALIDES,
                "Des champs sont invalides", request, erreurs);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ReponseErreur> gererConstraintViolation(ConstraintViolationException ex, HttpServletRequest request) {
        Map<String, String> erreurs = new LinkedHashMap<>();
        ex.getConstraintViolations().forEach(violation ->
                erreurs.putIfAbsent(violation.getPropertyPath().toString(), violation.getMessage()));
        log.warn("Contrainte violée sur {} : {}", request.getRequestURI(), erreurs);
        return construire(HttpStatus.BAD_REQUEST, ErrorCode.DONNEES_INVALIDES,
                "Des contraintes sont violées", request, erreurs);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ReponseErreur> gererCorpsIllisible(HttpMessageNotReadableException ex, HttpServletRequest request) {
        log.warn("Corps de requête illisible sur {}", request.getRequestURI(), ex);
        return construire(HttpStatus.BAD_REQUEST, ErrorCode.REQUETE_MALFORMEE,
                "Le corps de la requête est malformé ou illisible", request, null);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ReponseErreur> gererTypeParametre(MethodArgumentTypeMismatchException ex, HttpServletRequest request) {
        String message = String.format("Le paramètre '%s' a une valeur '%s' de type incorrect (attendu : %s)",
                ex.getName(), ex.getValue(), ex.getRequiredType() != null ? ex.getRequiredType().getSimpleName() : "inconnu");
        log.warn("Type de paramètre incorrect sur {} : {}", request.getRequestURI(), message);
        return construire(HttpStatus.BAD_REQUEST, ErrorCode.TYPE_PARAMETRE_INCORRECT, message, request, null);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ReponseErreur> gererParametreManquant(MissingServletRequestParameterException ex, HttpServletRequest request) {
        String message = String.format("Le paramètre requis '%s' est manquant", ex.getParameterName());
        log.warn("Paramètre manquant sur {} : {}", request.getRequestURI(), message);
        return construire(HttpStatus.BAD_REQUEST, ErrorCode.PARAMETRE_REQUIS_MANQUANT, message, request, null);
    }

    @ExceptionHandler(MissingPathVariableException.class)
    public ResponseEntity<ReponseErreur> gererCheminManquant(MissingPathVariableException ex, HttpServletRequest request) {
        String message = String.format("Le paramètre de chemin '%s' est manquant", ex.getVariableName());
        log.warn("Chemin variable manquant sur {} : {}", request.getRequestURI(), message);
        return construire(HttpStatus.BAD_REQUEST, ErrorCode.PARAMETRE_REQUIS_MANQUANT, message, request, null);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ReponseErreur> gererMethodeNonSupportee(HttpRequestMethodNotSupportedException ex, HttpServletRequest request) {
        String message = String.format("Méthode %s non supportée. Méthodes autorisées : %s",
                ex.getMethod(), ex.getSupportedHttpMethods());
        log.warn("Méthode non supportée sur {} : {}", request.getRequestURI(), message);
        return construire(HttpStatus.METHOD_NOT_ALLOWED, ErrorCode.METHODE_NON_SUPPORTEE, message, request, null);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ReponseErreur> gererRessourceAbsente(NoResourceFoundException ex, HttpServletRequest request) {
        String message = String.format("La ressource demandée est introuvable : %s", ex.getResourcePath());
        log.warn("Ressource absente sur {} : {}", request.getRequestURI(), message);
        return construire(HttpStatus.NOT_FOUND, ErrorCode.RESSOURCE_INTROUVABLE, message, request, null);
    }

    // ------------------------------------------------------------------ //
    //  Filet de sécurité : toute erreur non anticipée                     //
    // ------------------------------------------------------------------ //

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ReponseErreur> gererErreurInattendue(Exception ex, HttpServletRequest request) {
        log.error("Erreur inattendue sur {}", request.getRequestURI(), ex);
        return construire(HttpStatus.INTERNAL_SERVER_ERROR, ErrorCode.ERREUR_INTERNE,
                ErrorCode.ERREUR_INTERNE.getMessageDefaut(), request, null);
    }

    // ------------------------------------------------------------------ //
    //  Utilitaire de construction de la réponse                           //
    // ------------------------------------------------------------------ //

    private ResponseEntity<ReponseErreur> construire(HttpStatus statut, ErrorCode code, String message,
                                                     HttpServletRequest request, Map<String, String> erreursDeChamps) {
        ReponseErreur corps = ReponseErreur.builder()
                .timestamp(LocalDateTime.now())
                .statut(statut.value())
                .erreur(statut.getReasonPhrase())
                .code(code.name())
                .message(message)
                .chemin(request.getRequestURI())
                .erreursDeChamps(erreursDeChamps)
                .build();
        return ResponseEntity.status(statut).body(corps);
    }
}
