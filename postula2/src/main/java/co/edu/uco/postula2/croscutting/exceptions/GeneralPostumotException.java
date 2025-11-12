package co.edu.uco.postula2.croscutting.exceptions;

import co.edu.uco.postula2.croscutting.exceptions.enums.Layer;

public class GeneralPostumotException extends PostumotException {

    private static final long serialVersionUID = 1L;

    public GeneralPostumotException(final String userMessage, final String technicalMessage, final Exception rootException) {
        super(userMessage, technicalMessage, rootException, Layer.GENERAL);
    }

    public static final GeneralPostumotException create(final String userMessage, final String technicalMessage, final Exception rootException) {
        return new GeneralPostumotException(userMessage, technicalMessage, rootException);
    }

    public static final GeneralPostumotException create(final String userMessage) {
        return new GeneralPostumotException(userMessage, userMessage, new Exception());
    }

    public static final GeneralPostumotException create(final String userMessage, final String technicalMessage) {
        return new GeneralPostumotException(userMessage, technicalMessage, new Exception());
    }
}
