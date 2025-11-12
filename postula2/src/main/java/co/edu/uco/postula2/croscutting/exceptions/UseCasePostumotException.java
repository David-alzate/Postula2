package co.edu.uco.postula2.croscutting.exceptions;

import co.edu.uco.postula2.croscutting.exceptions.enums.Layer;

public class UseCasePostumotException extends PostumotException {

    private static final long serialVersionUID = 1L;

    public UseCasePostumotException(final String userMessage, final String technicalMessage, final Exception rootException) {
        super(userMessage, technicalMessage, rootException, Layer.USECASE);
    }

    public static final UseCasePostumotException create(final String userMessage, final String technicalMessage, final Exception rootException) {
        return new UseCasePostumotException(userMessage, technicalMessage, rootException);
    }

    public static final UseCasePostumotException create(final String userMessage) {
        return new UseCasePostumotException(userMessage, userMessage, new Exception());
    }

    public static final UseCasePostumotException create(final String userMessage, final String technicalMessage) {
        return new UseCasePostumotException(userMessage, technicalMessage, new Exception());
    }
}
