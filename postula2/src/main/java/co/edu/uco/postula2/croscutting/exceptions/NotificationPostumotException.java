package co.edu.uco.postula2.croscutting.exceptions;

import co.edu.uco.postula2.croscutting.exceptions.enums.Layer;

public class NotificationPostumotException extends PostumotException {

    private static final long serialVersionUID = 1L;

    private NotificationPostumotException(final String userMessage, final String technicalMessage, final Exception rootException) {
        super(userMessage, technicalMessage, rootException, Layer.NOTIFICATION);
    }

    public static NotificationPostumotException create(final String userMessage, final String technicalMessage, final Exception rootException) {
        return new NotificationPostumotException(userMessage, technicalMessage, rootException);
    }

    public static NotificationPostumotException create(final String userMessage, final String technicalMessage) {
        return new NotificationPostumotException(userMessage, technicalMessage, new Exception());
    }

    public static NotificationPostumotException create(final String userMessage) {
        return new NotificationPostumotException(userMessage, userMessage, new Exception());
    }
}
