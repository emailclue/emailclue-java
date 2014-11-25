package com.emailclue.api.builder;

import com.emailclue.api.model.response.EmailSent;

import java.util.LinkedList;
import java.util.List;

public class SendEmailBuilder {

    private static enum Source {
        TEMPLATE,
        PROVIDED
    }

    private final Source source;
    private String subject = "";
    private final List<String> to = new LinkedList<String>();
    private final List<String> cc = new LinkedList<String>();
    private TemplateDataBuilder dataBuilder;

    private SendEmailBuilder(Source source) {
        this.source = source;
    }


    public static SendEmailBuilder fromTemplate(String templateId) {
        return new SendEmailBuilder(Source.TEMPLATE);
    }

    public SendEmailBuilder to(String email) {
        to.add(email);
        return this;
    }

    public SendEmailBuilder cc(String email) {
        cc.add(email);
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
