package com.emailclue.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class EmailSend {

    private final List<EmailAddress> to;
    private final List<EmailAddress> cc;
    private final List<EmailAddress> bcc;
    private final String subject;
    private final List<EmailAttachment> attachments;
    private final Map<String, Object> data;

    @JsonCreator
    public EmailSend(
            @JsonProperty("to") List<EmailAddress> to,
            @JsonProperty("cc") List<EmailAddress> cc,
            @JsonProperty("bcc") List<EmailAddress> bcc,
            @JsonProperty("subject") String subject,
            @JsonProperty("attachments") List<EmailAttachment> attachments,
            @JsonProperty("data") Map<String, Object> data
    ) {
        this.to = to;
        this.cc = cc;
        this.bcc = bcc;
        this.subject = subject;
        this.attachments = attachments;
        this.data = data;
    }

    public List<EmailAddress> getTo() {
        return to;
    }

    public List<EmailAddress> getCc() {
        return cc;
    }

    public List<EmailAddress> getBcc() {
        return bcc;
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
