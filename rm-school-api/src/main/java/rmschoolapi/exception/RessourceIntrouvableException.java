package rmschoolapi.exception;

/**
 * Levée lorsqu'une ressource attendue n'existe pas (GET/UPDATE/DELETE sur une
 * entité absente de la base).
 */
public class RessourceIntrouvableException extends BusinessException {

    public RessourceIntrouvableException(String entite, Object id) {
        super(ErrorCode.RESSOURCE_INTROUVABLE, String.format("%s introuvable avec l'identifiant : %s", entite, id));
    }

    public RessourceIntrouvableException(String message) {
        super(ErrorCode.RESSOURCE_INTROUVABLE, message);
    }
}
