package co.edu.uco.postula2.infraestructure.primaryadapters.controller.rest;

import co.edu.uco.postula2.application.primaryports.dto.postulant.RegisterNewPostulantDTO;
import co.edu.uco.postula2.application.primaryports.interactor.postulant.RegisterNewPostulantInteractor;
import co.edu.uco.postula2.croscutting.exceptions.RulePostumotException;
import co.edu.uco.postula2.infraestructure.primaryadapters.controller.response.postulant.RegisterNewPostulantResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/postulantes")
public class PostulantController {

    private final RegisterNewPostulantInteractor registerNewPostulant;

    public PostulantController(RegisterNewPostulantInteractor registerNewPostulant) {
        this.registerNewPostulant = registerNewPostulant;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegisterNewPostulantResponse> registrarCiudad(@RequestBody RegisterNewPostulantDTO dto) {
        var httpStatusCode = HttpStatus.CREATED;
        var postulantResponse = new RegisterNewPostulantResponse();

        try {
            registerNewPostulant.execute(dto);
            postulantResponse.getMessages().add("Postulante registrado exitosamente.");

        } catch (final RulePostumotException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            postulantResponse.getMessages().add(excepcion.getUserMessage());
        } catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            postulantResponse.getMessages().add("Se ha presentado un problema inesperado. Por favor intente más tarde.");
        }

        return new ResponseEntity<>(postulantResponse, httpStatusCode);
    }


}
