package co.edu.uco.postula2.infraestructure.primaryadapters.controller.rest;

import co.edu.uco.postula2.application.primaryports.interactor.commons.GetDocumentTypeInteractor;
import co.edu.uco.postula2.croscutting.exceptions.PostumotException;
import co.edu.uco.postula2.infraestructure.primaryadapters.controller.response.commons.DocumentTypeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/document-types")
public class DocumentTypeController {

    private final GetDocumentTypeInteractor getDocumentTypes;

    public DocumentTypeController(GetDocumentTypeInteractor getDocumentTypes) {
        this.getDocumentTypes = getDocumentTypes;
    }

    @GetMapping
    public ResponseEntity<DocumentTypeResponse> getDocumentTypes() {
        var httpStatusCode = HttpStatus.ACCEPTED;
        var documentTypeResponse = new DocumentTypeResponse();

        try {
            documentTypeResponse.setData(getDocumentTypes.execute());
            documentTypeResponse.getMessages().add("Tipos de documento obtenidos exitosamente.");

        } catch (final PostumotException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            documentTypeResponse.getMessages().add(excepcion.getUserMessage());
        } catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            documentTypeResponse.getMessages().add("Se ha presentado un error inesperado. Por favor intente más tarde.");
        }

        return new ResponseEntity<>(documentTypeResponse, httpStatusCode);
    }
}
