package com.emailclue.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class EmailSend {

    public final List<EmailAddress> to;
    public final List<EmailAddress> cc;
    public final List<EmailAddress> bcc;
    public final String subject;
    public final List<EmailAttachment> attachments;
    public final Map<String, Object> data;

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
}
