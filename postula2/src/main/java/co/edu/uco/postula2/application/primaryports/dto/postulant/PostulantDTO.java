package co.edu.uco.postula2.application.primaryports.dto.postulant;

import co.edu.uco.postula2.application.primaryports.dto.commons.DocumentTypeDTO;
import co.edu.uco.postula2.croscutting.helpers.TextHelper;
import co.edu.uco.postula2.croscutting.helpers.UUIDHelper;

import java.util.UUID;

public class PostulantDTO {

    private UUID id;
    private Long document;
    private String firstName;
    private String secondName;
    private String lastName;
    private String lastSecondName;
    private Long phone;
    private String email;
    private DocumentTypeDTO documentType;

    public PostulantDTO(UUID id, Long document, String firstName, String secondName, String lastName,
                        String lastSecondName, Long phone, String email, DocumentTypeDTO documentType) {
        setId(id);
        setDocument(document);
        setFirstName(firstName);
        setSecondName(secondName);
        setLastName(lastName);
        setLastSecondName(lastSecondName);
        setPhone(phone);
        setEmail(email);
        setDocumentType(documentType);
    }

    public PostulantDTO() {
        setId(UUIDHelper.getDefault());
        setDocument(0L);
        setFirstName(TextHelper.EMPTY);
        setSecondName(TextHelper.EMPTY);
        setLastName(TextHelper.EMPTY);
        setLastSecondName(TextHelper.EMPTY);
        setPhone(0L);
        setEmail(TextHelper.EMPTY);
        setDocumentType(DocumentTypeDTO.create());
    }

    public static PostulantDTO create(UUID id, Long document, String firstName, String secondName, String lastName,
                                      String lastSecondName, Long phone, String email, DocumentTypeDTO documentType) {
        return new PostulantDTO(id, document, firstName, secondName, lastName, lastSecondName, phone, email, documentType);
    }

    public static PostulantDTO create() {
        return new PostulantDTO();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
    }

    public Long getDocument() {
        return document;
    }

    public void setDocument(Long document) {
        this.document = document;
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

    public DocumentTypeDTO getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentTypeDTO documentType) {
        this.documentType = documentType;
    }
}
