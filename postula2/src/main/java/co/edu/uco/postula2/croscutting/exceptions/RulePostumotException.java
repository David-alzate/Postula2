package co.edu.uco.postula2.croscutting.exceptions;

import co.edu.uco.postula2.croscutting.exceptions.enums.Layer;

public class RulePostumotException extends PostumotException {

    private static final long serialVersionUID = 1L;

    public RulePostumotException(final String userMessage, final String technicalMessage, final Exception rootException) {
        super(userMessage, technicalMessage, rootException, Layer.RULE);
    }

    public static final RulePostumotException create(final String userMessage, final String technicalMessage, final Exception rootException) {
        return new RulePostumotException(userMessage, technicalMessage, rootException);
    }

    public static final RulePostumotException create(final String userMessage) {
        return new RulePostumotException(userMessage, userMessage, new Exception());
    }

    public static final RulePostumotException create(final String userMessage, final String technicalMessage) {
        return new RulePostumotException(userMessage, technicalMessage, new Exception());
    }
}
