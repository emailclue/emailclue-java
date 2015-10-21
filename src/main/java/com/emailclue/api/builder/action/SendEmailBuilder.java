package com.emailclue.api.builder.action;

import com.emailclue.api.builder.data.RecipientBuilder;
import com.emailclue.api.builder.data.TemplateDataBuilder;
import com.emailclue.api.model.request.Recipient;
import com.emailclue.api.model.response.EmailSent;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.emailclue.api.EmailClue.recipient;

public class SendEmailBuilder {

    private static enum Source {
        TEMPLATE,
        PROVIDED
    }

    private final Source source;
    private String subject = "";
    private final List<Recipient> to = new LinkedList<Recipient>();
    private final List<Recipient> cc = new LinkedList<Recipient>();
    private final List<Recipient> bcc = new LinkedList<Recipient>();
    private TemplateDataBuilder dataBuilder;

    private SendEmailBuilder(Source source) {
        this.source = source;
    }


    public static SendEmailBuilder fromTemplate(String templateId) {
        return new SendEmailBuilder(Source.TEMPLATE);
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


    public SendEmailBuilder subject(String subject) {
        this.subject = subject;
        return this;
    }

    public SendEmailBuilder data(TemplateDataBuilder dataBuilder) {
        this.dataBuilder = dataBuilder;
        return this;
    }

    public SendEmailBuilder data(Map<String, Object> data) {
        this.dataBuilder = TemplateDataBuilder.map(data);
        return this;
    }

    public EmailSent invoke() {
        return null;
    }

}
