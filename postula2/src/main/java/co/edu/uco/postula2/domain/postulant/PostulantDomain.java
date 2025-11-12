package co.edu.uco.postula2.domain.postulant;

import co.edu.uco.postula2.domain.Domain;
import co.edu.uco.postula2.domain.commons.DocumentTypeDomain;

import java.util.UUID;

public class PostulantDomain extends Domain {

    private Long document;
    private String firstName;
    private String secondName;
    private String lastName;
    private String lastSecondName;
    private Long phone;
    private String email;
    private DocumentTypeDomain documentType;

    public PostulantDomain(UUID id, Long document, String firstName, String secondName, String lastName, String lastSecondName, Long phone, String email, DocumentTypeDomain documentType) {
        super(id);
        setDocument(document);
        setFirstName(firstName);
        setSecondName(secondName);
        setLastName(lastName);
        setLastSecondName(lastSecondName);
        setPhone(phone);
        setEmail(email);
        setDocumentType(documentType);
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

    public DocumentTypeDomain getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentTypeDomain documentType) {
        this.documentType = documentType;
    }
}
