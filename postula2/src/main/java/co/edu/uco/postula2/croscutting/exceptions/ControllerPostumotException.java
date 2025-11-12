package co.edu.uco.postula2.croscutting.exceptions;

import co.edu.uco.postula2.croscutting.exceptions.enums.Layer;

public class ControllerPostumotException extends PostumotException {

    private static final long serialVersionUID = 1L;

    public ControllerPostumotException(final String userMessage, final String technicalMessage,
                                       final Exception rootException) {
        super(userMessage, technicalMessage, rootException, Layer.CONTROLLER);
    }

    public static final ControllerPostumotException create(final String userMessage, final String technicalMessage,
                                                           final Exception rootException) {
        return new ControllerPostumotException(userMessage, technicalMessage, rootException);
    }

    public static final ControllerPostumotException create(final String userMessage) {
        return new ControllerPostumotException(userMessage, userMessage, new Exception());
    }

    public static final ControllerPostumotException create(final String userMessage, final String technicalMessage) {
        return new ControllerPostumotException(userMessage, technicalMessage, new Exception());
    }
}
