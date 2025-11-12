package co.edu.uco.postula2.infraestructure.primaryadapters.controller.rest;

import co.edu.uco.postula2.application.primaryports.dto.postulant.RegisterNewPostulantDTO;
import co.edu.uco.postula2.application.primaryports.interactor.postulant.GetPostulantsInteractor;
import co.edu.uco.postula2.application.primaryports.interactor.postulant.RegisterNewPostulantInteractor;
import co.edu.uco.postula2.croscutting.exceptions.NotificationPostumotException;
import co.edu.uco.postula2.croscutting.exceptions.PostumotException;
import co.edu.uco.postula2.croscutting.exceptions.RulePostumotException;
import co.edu.uco.postula2.infraestructure.primaryadapters.controller.response.postulant.GetPostulantResponse;
import co.edu.uco.postula2.infraestructure.primaryadapters.controller.response.postulant.RegisterNewPostulantResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/postulantes")
public class PostulantController {

    private final RegisterNewPostulantInteractor registerNewPostulant;
    private final GetPostulantsInteractor getPostulants;

    public PostulantController(RegisterNewPostulantInteractor registerNewPostulant,
                               GetPostulantsInteractor getPostulants) {
        this.registerNewPostulant = registerNewPostulant;
        this.getPostulants = getPostulants;
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
        } catch (final NotificationPostumotException excepcion) {
            httpStatusCode = HttpStatus.CREATED;
            postulantResponse.getMessages().add("Postulante registrado, pero no se pudo enviar la notificación.");
            postulantResponse.getMessages().add(excepcion.getUserMessage());
        } catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            postulantResponse.getMessages().add("Se ha presentado un problema inesperado. Por favor intente más tarde.");
        }

        return new ResponseEntity<>(postulantResponse, httpStatusCode);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetPostulantResponse> getPostulants() {
        var httpStatusCode = HttpStatus.ACCEPTED;
        var response = new GetPostulantResponse();

        try {
            response.setData(getPostulants.execute());
            response.getMessages().add("Postulantes obtenidos exitosamente.");
        } catch (final PostumotException exception) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            response.getMessages().add(exception.getUserMessage());
        } catch (final Exception exception) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            response.getMessages().add("Se ha presentado un error inesperado. Por favor intente más tarde.");
        }

        return new ResponseEntity<>(response, httpStatusCode);
    }


}
