package rmschoolapi.exception;

/**
 * Levée lorsqu'une règle métier explicite est enfreinte (règle de gestion
 * qui ne relève pas d'une simple validation de format).
 */
public class OperationInterditeException extends BusinessException {

    public OperationInterditeException(String message) {
        super(ErrorCode.OPERATION_INTERDITE, message);
    }
}
