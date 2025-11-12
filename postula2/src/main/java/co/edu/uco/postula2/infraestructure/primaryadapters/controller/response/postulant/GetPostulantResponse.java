package co.edu.uco.postula2.infraestructure.primaryadapters.controller.response.postulant;

import co.edu.uco.postula2.application.primaryports.dto.postulant.PostulantDTO;
import co.edu.uco.postula2.infraestructure.primaryadapters.controller.response.Response;

import java.util.ArrayList;

public class GetPostulantResponse extends Response<PostulantDTO> {

    public GetPostulantResponse() {
        setMessages(new ArrayList<>());
        setData(new ArrayList<>());
    }
}
