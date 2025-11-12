package co.edu.uco.postula2.infraestructure.secondaryadapters.notificationservice;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import co.edu.uco.postula2.application.secondaryports.service.NotificationService;
import co.edu.uco.postula2.croscutting.exceptions.NotificationPostumotException;
import co.edu.uco.postula2.croscutting.helpers.TextHelper;
import co.edu.uco.postula2.domain.commons.DocumentTypeDomain;
import co.edu.uco.postula2.domain.postulant.PostulantDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SendGridNotificationService implements NotificationService {

    private static final Logger logger = LoggerFactory.getLogger(SendGridNotificationService.class);

    private final SendGrid sendGrid;
    private final String senderEmail;
    private final String recipientEmail;

    public SendGridNotificationService(
            SendGrid sendGrid,
            @Value("${postula2.notification.from-email}") String senderEmail,
            @Value("${postula2.notification.to-email}") String recipientEmail) {
        this.sendGrid = sendGrid;
        this.senderEmail = senderEmail;
        this.recipientEmail = recipientEmail;
    }

    @Override
    public void notifyNewPostulant(PostulantDomain postulantDomain) {
        var subject = buildSubject(postulantDomain);
        var body = buildBody(postulantDomain);
        sendEmail(subject, body);
    }

    private void sendEmail(String subject, String body) {
        Email from = new Email(senderEmail);
        Email to = new Email(recipientEmail);
        Content content = new Content("text/plain", body);
        Mail mail = new Mail(from, subject, to, content);

        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sendGrid.api(request);
            if (response.getStatusCode() >= 400) {
                throw NotificationPostumotException.create("No fue posible enviar la notificación del postulante registrado.",
                        "SendGrid respondió con código " + response.getStatusCode());
            }
            logger.info("Notificación de nuevo postulante enviada. Código de respuesta {}", response.getStatusCode());
        } catch (IOException exception) {
            throw NotificationPostumotException.create("No fue posible enviar la notificación del postulante registrado.",
                    exception.getMessage(), exception);
        }
    }

    private String buildSubject(PostulantDomain postulantDomain) {
        String firstName = safeText(postulantDomain.getFirstName());
        String lastName = safeText(postulantDomain.getLastName());
        return String.format("Nuevo postulante: %s %s", firstName, lastName).trim();
    }

    private String buildBody(PostulantDomain postulantDomain) {
        String fullName = formatFullName(postulantDomain);

        DocumentTypeDomain documentType = postulantDomain.getDocumentType();
        String documentTypeName = documentType != null ? safeText(documentType.getNombre()) : "N/A";

        String document = postulantDomain.getDocument() != null ? postulantDomain.getDocument().toString() : "N/A";
        String phone = postulantDomain.getPhone() != null ? postulantDomain.getPhone().toString() : "N/A";
        String email = safeText(postulantDomain.getEmail());

        return "Nuevo postulante registrado" +
                "\n\n" +
                "Nombre completo: " + fullName +
                "\nDocumento: " + document + " (" + documentTypeName + ")" +
                "\nTeléfono: " + phone +
                "\nCorreo: " + email +
                "\n\nEste correo se envía automáticamente desde PostuMOT.";
    }

    private String safeText(String value) {
        return TextHelper.isEmptyApplyingTrim(value) ? "N/A" : TextHelper.applyTrim(value);
    }

    private String formatFullName(PostulantDomain postulantDomain) {
        StringBuilder builder = new StringBuilder();
        appendIfPresent(builder, postulantDomain.getFirstName());
        appendIfPresent(builder, postulantDomain.getSecondName());
        appendIfPresent(builder, postulantDomain.getLastName());
        appendIfPresent(builder, postulantDomain.getLastSecondName());
        String result = builder.toString().trim();
        return result.isEmpty() ? "N/A" : result;
    }

    private void appendIfPresent(StringBuilder builder, String value) {
        if (!TextHelper.isEmptyApplyingTrim(value)) {
            if (builder.length() > 0) {
                builder.append(' ');
            }
            builder.append(TextHelper.applyTrim(value));
        }
    }
}
