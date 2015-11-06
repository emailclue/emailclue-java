package com.emailclue.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InlineEmailAttachment extends AbstractEmailAttachment {
    public InlineEmailAttachment(@JsonProperty("name") String name, @JsonProperty("data") byte[] data) {
        super(name, data);
    }
}
