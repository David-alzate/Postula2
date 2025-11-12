package co.edu.uco.postula2.croscutting.exceptions;

import co.edu.uco.postula2.croscutting.exceptions.enums.Layer;

public class ApplicationPostumotException extends PostumotException {

    private static final long serialVersionUID = 1L;

    public ApplicationPostumotException(final String userMessage, final String technicalMessage, final Exception rootException) {
        super(userMessage, technicalMessage, rootException, Layer.APPLICATION);
    }

    public static final ApplicationPostumotException create(final String userMessage, final String technicalMessage, final Exception rootException) {
        return new ApplicationPostumotException(userMessage, technicalMessage, rootException);
    }

    public static final ApplicationPostumotException create(final String userMessage) {
        return new ApplicationPostumotException(userMessage, userMessage, new Exception());
    }

    public static final ApplicationPostumotException create(final String userMessage, final String technicalMessage) {
        return new ApplicationPostumotException(userMessage, technicalMessage, new Exception());
    }
}
