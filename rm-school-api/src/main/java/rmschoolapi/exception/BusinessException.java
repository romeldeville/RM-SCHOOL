package rmschoolapi.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Exception métier de base. Toutes les exceptions métier du projet en héritent.
 * Elle transporte un {@link ErrorCode} qui détermine le statut HTTP et le message
 * propagé au client par le {@link GestionnaireExceptionsGlobal}.
 */
@Getter
public abstract class BusinessException extends RuntimeException {

    private final ErrorCode code;

    protected BusinessException(ErrorCode code) {
        this(code, code.getMessageDefaut(), null);
    }

    protected BusinessException(ErrorCode code, String message) {
        this(code, message, null);
    }

    protected BusinessException(ErrorCode code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public HttpStatus getStatut() {
        return code.getStatut();
    }
}
