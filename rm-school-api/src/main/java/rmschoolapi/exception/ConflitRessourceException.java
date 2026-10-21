package rmschoolapi.exception;

/**
 * Levée lorsqu'une opération viole une contrainte d'unicité ou une règle
 * d'intégrité métier (doublon, référencement interdit, etc.).
 */
public class ConflitRessourceException extends BusinessException {

    public ConflitRessourceException(String message) {
        super(ErrorCode.CONFLIT_RESSOURCE, message);
    }

    public static ConflitRessourceException doublon(String champ, Object valeur) {
        return new ConflitRessourceException(String.format("Une ressource existe déjà avec %s = %s", champ, valeur));
    }
}
