package co.edu.uco.postula2.application.primaryports.dto.commons;

import co.edu.uco.postula2.croscutting.helpers.TextHelper;
import co.edu.uco.postula2.croscutting.helpers.UUIDHelper;

import java.util.UUID;

public final class DocumentTypeDTO {

    private UUID id;
    private String nombre;

    public DocumentTypeDTO(UUID id, String nombre) {
        setId(id);
        setNombre(nombre);
    }

    public DocumentTypeDTO() {
        setId(UUIDHelper.getDefault());
        setNombre(TextHelper.EMPTY);
    }

    public static DocumentTypeDTO create(UUID id, String nombre) {
        return new DocumentTypeDTO(id, nombre);
    }

    public static DocumentTypeDTO create() {
        return new DocumentTypeDTO();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
    }
}
