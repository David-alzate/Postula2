package co.edu.uco.postula2.infraestructure.primaryadapters.controller.response.postulant;

import co.edu.uco.postula2.application.primaryports.dto.postulant.RegisterNewPostulantDTO;
import co.edu.uco.postula2.infraestructure.primaryadapters.controller.response.Response;

import java.util.ArrayList;

public class RegisterNewPostulantResponse extends Response<RegisterNewPostulantDTO> {

    public RegisterNewPostulantResponse() {
        setMessages(new ArrayList<>());
        setData(new ArrayList<>());
    }
}
