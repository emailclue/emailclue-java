package com.emailclue.api.builder.action;

import com.emailclue.api.builder.data.RecipientBuilder;
import com.emailclue.api.builder.data.TemplateDataBuilder;
import com.emailclue.api.model.request.Recipient;
import com.emailclue.api.model.response.EmailSent;

import java.util.LinkedList;
import java.util.List;

import static com.emailclue.api.EmailClue.recipient;

public class SendEmailBuilder {

    private static enum Source {
        TEMPLATE,
        PROVIDED
    }

    private final Source source;
    private String subject = "";
    private final List<Recipient> to = new LinkedList<>();
    private final List<Recipient> cc = new LinkedList<>();
    private TemplateDataBuilder dataBuilder;

    private SendEmailBuilder(Source source) {
        this.source = source;
    }


    public static SendEmailBuilder fromTemplate(String templateId) {
        return new SendEmailBuilder(Source.TEMPLATE);
    }

    public SendEmailBuilder to(String email) {
        to(recipient().address(email));
        return this;
    }

    public SendEmailBuilder to(RecipientBuilder recipient) {
        to.add(recipient.build());
        return this;
    }

    public SendEmailBuilder cc(String email) {
        cc.add(recipient().address(email).build());
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

    public EmailSent invoke() {
        return null;
    }

}
