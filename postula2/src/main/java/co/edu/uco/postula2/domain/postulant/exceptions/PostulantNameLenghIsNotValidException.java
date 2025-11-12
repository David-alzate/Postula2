package co.edu.uco.postula2.domain.postulant.exceptions;

import co.edu.uco.postula2.croscutting.exceptions.RulePostumotException;

public class PostulantNameLenghIsNotValidException extends RulePostumotException {

    private static final long serialVersionUID = 1L;

    private PostulantNameLenghIsNotValidException(final String userMessage) {
        super(userMessage, userMessage, new Exception());

    }

    public static final PostulantNameLenghIsNotValidException create() {
        var userMessage = "El nombre del postulante no cumple con la longitud requerida.";
        return new PostulantNameLenghIsNotValidException(userMessage);
    }

}
