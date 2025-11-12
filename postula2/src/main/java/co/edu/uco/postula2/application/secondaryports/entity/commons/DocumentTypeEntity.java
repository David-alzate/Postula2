package co.edu.uco.postula2.application.secondaryports.entity.commons;

import co.edu.uco.postula2.croscutting.helpers.TextHelper;
import co.edu.uco.postula2.croscutting.helpers.UUIDHelper;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "document_type")
public final class DocumentTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String nombre;

    public DocumentTypeEntity(UUID id, String nombre) {
        setId(id);
        setNombre(nombre);
    }

    public DocumentTypeEntity() {
        setId(UUIDHelper.getDefault());
        setNombre(TextHelper.EMPTY);
    }

    public static DocumentTypeEntity create(UUID id, String nombre) {
        return new DocumentTypeEntity(id, nombre);
    }

    public static DocumentTypeEntity create(UUID id) {
        return new DocumentTypeEntity(id, TextHelper.EMPTY);
    }

    public static DocumentTypeEntity create() {
        return new DocumentTypeEntity();
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
