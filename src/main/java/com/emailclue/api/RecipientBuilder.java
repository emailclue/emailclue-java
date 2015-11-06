package com.emailclue.api;

import com.emailclue.api.model.Recipient;

public class RecipientBuilder {

    private String name;
    private String address;

    private RecipientBuilder() {
    }

    public static RecipientBuilder recipient() {
        return new RecipientBuilder();
    }

    public RecipientBuilder name(String name) {
        this.name = name;
        return this;
    }

    public RecipientBuilder address(String address) {
        this.address = address;
        return this;
    }

    public Recipient build() {
        return new Recipient(name, address);
    }
}
