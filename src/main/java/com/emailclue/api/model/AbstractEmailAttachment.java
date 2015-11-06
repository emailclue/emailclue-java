package com.emailclue.api.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(
        use = Id.NAME,
        include = As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = EmailAttachment.class, name = "attachment"),
        @JsonSubTypes.Type(value = InlineEmailAttachment.class, name = "inline")
})
public abstract class AbstractEmailAttachment {

    protected final String name;
    protected final byte[] data;

    protected AbstractEmailAttachment(final String name, final byte[] data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public byte[] getData() {
        return data;
    }

}
