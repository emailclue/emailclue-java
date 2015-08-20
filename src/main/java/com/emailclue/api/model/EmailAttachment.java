package com.emailclue.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailAttachment {

    public final String name;
    public final byte[] data;

    @JsonCreator
    public EmailAttachment(
            @JsonProperty("name") String name,
            @JsonProperty("data") byte[] data) {
        this.name = name;
        this.data = data;
    }

}
