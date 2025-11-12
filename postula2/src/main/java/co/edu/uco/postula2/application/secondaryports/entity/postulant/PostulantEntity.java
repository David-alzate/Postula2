package co.edu.uco.postula2.application.secondaryports.entity.postulant;

import co.edu.uco.postula2.application.secondaryports.entity.commons.DocumentTypeEntity;
import co.edu.uco.postula2.croscutting.helpers.TextHelper;
import co.edu.uco.postula2.croscutting.helpers.UUIDHelper;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "postulant")
public class PostulantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "last_second_name")
    private String lastSecondName;

    @Column(name = "pone")
    private Long phone;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "document_type_id")
    private DocumentTypeEntity documentType;

    public PostulantEntity(UUID id, String firstName, String secondName, String lastName, String lastSecondName, Long phone, String email, DocumentTypeEntity documentType) {
        setId(id);
        setFirstName(firstName);
        setSecondName(secondName);
        setLastName(lastName);
        setLastSecondName(lastSecondName);
        setPhone(phone);
        setEmail(email);
        setDocumentType(documentType);
    }

    public PostulantEntity() {
        setId(UUIDHelper.getDefault());
        setFirstName(TextHelper.EMPTY);
        setSecondName(TextHelper.EMPTY);
        setLastName(TextHelper.EMPTY);
        setLastSecondName(TextHelper.EMPTY);
        setPhone(0L);
        setEmail(TextHelper.EMPTY);
        setDocumentType(DocumentTypeEntity.create());
    }

    public static PostulantEntity create(UUID id, String firstName, String secondName, String lastName, String lastSecondName, Long phone, String email, DocumentTypeEntity documentType) {
        return new PostulantEntity(id, firstName, secondName, lastName, lastSecondName, phone, email, documentType);
    }

    public static PostulantEntity create(UUID id) {
        return new PostulantEntity(id, TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY, 0L, TextHelper.EMPTY, DocumentTypeEntity.create());
    }

    public static PostulantEntity create() {
        return new PostulantEntity(UUIDHelper.getDefault(), TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY, 0L, TextHelper.EMPTY, DocumentTypeEntity.create());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastSecondName() {
        return lastSecondName;
    }

    public void setLastSecondName(String lastSecondName) {
        this.lastSecondName = lastSecondName;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DocumentTypeEntity getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentTypeEntity documentType) {
        this.documentType = documentType;
    }
}
