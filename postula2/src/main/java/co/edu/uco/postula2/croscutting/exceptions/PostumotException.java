package co.edu.uco.postula2.croscutting.exceptions;

import co.edu.uco.postula2.croscutting.exceptions.enums.Layer;
import co.edu.uco.postula2.croscutting.helpers.ObjectHelper;
import co.edu.uco.postula2.croscutting.helpers.TextHelper;

public class PostumotException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String userMessage;
    private Layer layer;

    public PostumotException(final String userMessage, final String technicalMessage, final Exception rootException,
                           final Layer layer) {
        super(ObjectHelper.getDefault(technicalMessage, TextHelper.applyTrim(userMessage)),
                ObjectHelper.getDefault(rootException, new Exception()));
        setUserMessage(userMessage);
        setLayer(layer);
    }

    public String getUserMessage() {
        return userMessage;
    }

    private void setUserMessage(final String userMessage) {
        this.userMessage = TextHelper.applyTrim(userMessage);
    }

    public Layer getLayer() {
        return layer;
    }

    private void setLayer(final Layer layer) {
        this.layer = ObjectHelper.getDefault(layer, Layer.GENERAL);
    }
}
