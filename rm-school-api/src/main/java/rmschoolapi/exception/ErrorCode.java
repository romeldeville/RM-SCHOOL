package rmschoolapi.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // Ressources
    RESSOURCE_INTROUVABLE(HttpStatus.NOT_FOUND, "Ressource introuvable"),
    CONFLIT_RESSOURCE(HttpStatus.CONFLICT, "Conflit de ressource"),

    // Validation / métier
    DONNEES_INVALIDES(HttpStatus.BAD_REQUEST, "Données invalides"),
    OPERATION_INTERDITE(HttpStatus.FORBIDDEN, "Opération interdite"),

    // Authentification / autorisation
    NON_AUTORISE(HttpStatus.UNAUTHORIZED, "Authentification requise"),
    ACCES_INTERDIT(HttpStatus.FORBIDDEN, "Accès refusé"),

    // Requête
    REQUETE_MALFORMEE(HttpStatus.BAD_REQUEST, "Requête malformée"),
    TYPE_PARAMETRE_INCORRECT(HttpStatus.BAD_REQUEST, "Type de paramètre incorrect"),
    PARAMETRE_REQUIS_MANQUANT(HttpStatus.BAD_REQUEST, "Paramètre requis manquant"),
    METHODE_NON_SUPPORTEE(HttpStatus.METHOD_NOT_ALLOWED, "Méthode HTTP non supportée"),
    ENTITE_NON_SUPPORTEE(HttpStatus.UNPROCESSABLE_ENTITY, "Entité non supportée"),

    // Système
    ERREUR_INTERNE(HttpStatus.INTERNAL_SERVER_ERROR, "Erreur interne du serveur");

    private final HttpStatus statut;
    private final String messageDefaut;
}
