package com.emailclue.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public class EmailSend {

    @NotNull
    private final List<Recipient> to;
    private final List<Recipient> cc;
    private final List<Recipient> bcc;
    @NotNull
    private final List<Recipient> replyTo;
    @NotNull
    private final String fromName;
    private final String subject;
    private final List<AbstractEmailAttachment> attachments;
    @NotNull
    @Valid
    private final Template template;

    @JsonCreator
    public EmailSend(
            @JsonProperty("to") List<Recipient> to,
            @JsonProperty("cc") List<Recipient> cc,
            @JsonProperty("bcc") List<Recipient> bcc,
            @JsonProperty("replyTo") List<Recipient> replyTo,
            @JsonProperty("fromName") String fromName,
            @JsonProperty("subject") String subject,
            @JsonProperty("attachments") List<AbstractEmailAttachment> attachments,
            @JsonProperty("template") Template template
    ) {
        this.to = to;
        this.cc = cc;
        this.bcc = bcc;
        this.replyTo = replyTo;
        this.fromName = fromName;
        this.subject = subject;
        this.attachments = attachments;
        this.template = template;
    }

    public List<Recipient> getTo() {
        return to;
    }

    public List<Recipient> getCc() {
        return cc;
    }

    public List<Recipient> getBcc() {
        return bcc;
    }

    public String getFromName() {
        return fromName;
    }

    public String getSubject() {
        return subject;
    }

    public List<AbstractEmailAttachment> getAttachments() {
        return attachments;
    }

    public Template getTemplate() {
        return template;
    }

}
