package com.emailclue.api;

import com.emailclue.api.model.AbstractEmailAttachment;
import com.emailclue.api.model.EmailSend;
import com.emailclue.api.model.EmailSent;
import com.emailclue.api.model.Recipient;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.emailclue.api.EmailClue.recipient;
import static javax.ws.rs.client.Entity.json;

public class SendEmailBuilder {

    public SendEmailBuilder templateData(Map<String, Object> data) {
        templateBuilder.data = data;
        return this;
    }

    private static enum Source {
        TEMPLATE,
        PROVIDED
    }

    private String subject = "";
    private final List<Recipient> to = new LinkedList<>();
    private final List<Recipient> cc = new LinkedList<>();
    private final List<Recipient> bcc = new LinkedList<>();
    private final List<Recipient> replyTo = new LinkedList<>();
    private final String fromName = "no-reply";
    private List<AttachmentBuilder> attachmentBuilder = new LinkedList<>();
    protected TemplateBuilder templateBuilder;

    public SendEmailBuilder() {
    }

    public static SendEmailFromTemplateBuilder fromTemplate(String templateId) {
        return new SendEmailFromTemplateBuilder(templateId);
    }

    // to
    public SendEmailBuilder to(RecipientBuilder... recipients) {
        for (RecipientBuilder recipient : recipients) {
            to.add(recipient.build());
        }
        return this;
    }

    public SendEmailBuilder to(String... emails) {
        for (String email : emails) {
            to(recipient().address(email));
        }
        return this;
    }

    public SendEmailBuilder attachment(AttachmentBuilder attachment) {
        this.attachmentBuilder.add(attachment);
        return this;
    }

    public SendEmailBuilder to(Iterable<String> emails) {
        for (String email : emails) {
            to(recipient().address(email));
        }
        return this;
    }

    // cc
    public SendEmailBuilder cc(RecipientBuilder... recipients) {
        for (RecipientBuilder recipient : recipients) {
            cc.add(recipient.build());
        }
        return this;
    }

    public SendEmailBuilder cc(String... emails) {
        for (String email : emails) {
            cc(recipient().address(email));
        }
        return this;
    }

    public SendEmailBuilder cc(Iterable<String> emails) {
        for (String email : emails) {
            cc(recipient().address(email));
        }
        return this;
    }

    // bcc
    public SendEmailBuilder bcc(RecipientBuilder... recipients) {
        for (RecipientBuilder recipient : recipients) {
            bcc.add(recipient.build());
        }
        return this;
    }

    public SendEmailBuilder bcc(String... emails) {
        for (String email : emails) {
            bcc(recipient().address(email));
        }
        return this;
    }

    public SendEmailBuilder bcc(Iterable<String> emails) {
        for (String email : emails) {
            bcc(recipient().address(email));
        }
        return this;
    }

    public SendEmailBuilder replyTo(RecipientBuilder... recipients) {
        for (RecipientBuilder recipient : recipients) {
            replyTo.add(recipient.build());
        }
        return this;
    }


    public SendEmailBuilder subject(String subject) {
        this.subject = subject;
        return this;
    }

    /* package */ EmailSent invoke(EmailClueConfig config) {

        Response response = config.getWebTarget()
                .path("/email/message/send")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + config.apiKey)
                .post(json(build()));

        if (Response.Status.Family.SUCCESSFUL == response.getStatusInfo().getFamily()) {
            return response.readEntity(EmailSent.class);
        }

        System.err.println("ERROR " + response.readEntity(String.class));
        throw new WebApplicationException("Invalid response");
    }

    private EmailSend build() {
        List<AbstractEmailAttachment> attachments = new ArrayList<>();
        for (AttachmentBuilder attachBuilder : attachmentBuilder) {
            attachments.add(attachBuilder.build());
        }

        return new EmailSend(
                to, cc, bcc, replyTo, fromName,
                subject, attachments,
                templateBuilder.build()
        );
    }

}
