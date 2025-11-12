package co.edu.uco.postula2.infraestructure.primaryadapters.controller.response.commons;

import co.edu.uco.postula2.application.primaryports.dto.commons.DocumentTypeDTO;
import co.edu.uco.postula2.infraestructure.primaryadapters.controller.response.Response;

import java.util.ArrayList;

public class DocumentTypeResponse extends Response<DocumentTypeDTO> {

    public DocumentTypeResponse() {
        setMessages(new ArrayList<>());
        setData(new ArrayList<>());
    }
}
