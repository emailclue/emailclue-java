package com.emailclue.api.model;

import com.emailclue.api.model.request.Recipient;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

public class EmailSend {

    @NotNull
    private final List<Recipient> to;
    private final List<Recipient> cc;
    private final List<Recipient> bcc;
    @NotNull
    private final Recipient from;
    private final String subject;
    private final List<EmailAttachment> attachments;
    private final Map<String, Object> data;

    @JsonCreator
    public EmailSend(
            @JsonProperty("to") List<Recipient> to,
            @JsonProperty("cc") List<Recipient> cc,
            @JsonProperty("bcc") List<Recipient> bcc,
            @JsonProperty("from") Recipient from,
            @JsonProperty("subject") String subject,
            @JsonProperty("attachments") List<EmailAttachment> attachments,
            @JsonProperty("data") Map<String, Object> data
    ) {
        this.to = to;
        this.cc = cc;
        this.bcc = bcc;
        this.from = from;
        this.subject = subject;
        this.attachments = attachments;
        this.data = data;
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

    public Recipient getFrom() {
        return from;
    }

    public String getSubject() {
        return subject;
    }

    public List<EmailAttachment> getAttachments() {
        return attachments;
    }

    public Map<String, Object> getData() {
        return data;
    }

}
