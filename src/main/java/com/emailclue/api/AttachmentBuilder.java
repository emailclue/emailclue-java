package com.emailclue.api;

import com.emailclue.api.model.AbstractEmailAttachment;
import com.emailclue.api.model.EmailAttachment;
import com.emailclue.api.model.InlineEmailAttachment;

public class AttachmentBuilder {

    private final String disposition;
    private byte[] data;
    private String mimeType;

    public AttachmentBuilder(String disposition) {
        this.disposition = disposition;
    }

    public static AttachmentBuilder attachment() {
        return new AttachmentBuilder("attachment");
    }

    public static AttachmentBuilder inlineAttachment() {
        return new AttachmentBuilder("inline");
    }

    public AttachmentBuilder data(byte[] data, String mimeType) {
        this.data = data;
        this.mimeType = mimeType;
        return this;
    }

    /* package */ AbstractEmailAttachment build() {
        switch(disposition) {
            case "attachment":
                return new EmailAttachment(null, data);
            case "inline":
                return new InlineEmailAttachment(null, data);
            default:
                throw new IllegalArgumentException("Invalid disposition type '" + disposition + "'");
        }
    }

}
