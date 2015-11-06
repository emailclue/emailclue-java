package com.emailclue.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Recipient {

    private static final String NAME    = "name";
    private static final String ADDRESS = "address";

    private final String name;
    private final String address;

    @JsonCreator
    public Recipient(@JsonProperty(NAME) final String name,
                     @JsonProperty(ADDRESS) final String address) {
        this.name = name;
        this.address = address;
    }

    @JsonProperty(NAME)
    public String getName() {
        return name;
    }

    @JsonProperty(ADDRESS)
    public String getAddress() {
        return address;
    }
}
