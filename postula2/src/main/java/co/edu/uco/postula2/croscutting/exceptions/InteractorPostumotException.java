package co.edu.uco.postula2.croscutting.exceptions;

import co.edu.uco.postula2.croscutting.exceptions.enums.Layer;

public class InteractorPostumotException extends PostumotException {

    private static final long serialVersionUID = 1L;

    public InteractorPostumotException(final String userMessage, final String technicalMessage, final Exception rootException) {
        super(userMessage, technicalMessage, rootException, Layer.INTERACTOR);
    }

    public static final InteractorPostumotException create(final String userMessage, final String technicalMessage, final Exception rootException) {
        return new InteractorPostumotException(userMessage, technicalMessage, rootException);
    }

    public static final InteractorPostumotException create(final String userMessage) {
        return new InteractorPostumotException(userMessage, userMessage, new Exception());
    }

    public static final InteractorPostumotException create(final String userMessage, final String technicalMessage) {
        return new InteractorPostumotException(userMessage, technicalMessage, new Exception());
    }
}
