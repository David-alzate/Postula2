package co.edu.uco.postula2.domain.commons;

import co.edu.uco.postula2.croscutting.helpers.TextHelper;
import co.edu.uco.postula2.croscutting.helpers.UUIDHelper;
import co.edu.uco.postula2.domain.Domain;

import java.util.UUID;

public class DocumentTypeDomain extends Domain {

    private String nombre;

    public DocumentTypeDomain(UUID id, String nombre) {
        super(id);
        setNombre(nombre);
    }

    public DocumentTypeDomain() {
        super(UUIDHelper.getDefault());
        setNombre(TextHelper.EMPTY);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
