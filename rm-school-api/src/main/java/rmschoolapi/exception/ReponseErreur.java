package rmschoolapi.exception;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Corps de réponse standardisé retourné par le {@link GestionnaireExceptionsGlobal}
 * en cas d'erreur. Le champ {@code erreursDeChamps} est renseigné uniquement pour
 * les erreurs de validation (Bean Validation).
 */
@Getter
@Builder
public class ReponseErreur {

    private final LocalDateTime timestamp;
    private final int statut;
    private final String erreur;
    private final String code;
    private final String message;
    private final String chemin;
    private final Map<String, String> erreursDeChamps;
}
