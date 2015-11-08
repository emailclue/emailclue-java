package com.emailclue.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailSent {

    private final String messageId;

    @JsonCreator()
    public EmailSent(@JsonProperty("messageId") String messageId) {
        this.messageId = messageId;
    }

    public String getMessageId() {
        return messageId;
    }

}
