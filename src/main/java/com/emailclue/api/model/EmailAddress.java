package com.emailclue.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailAddress {

    public final String name;
    public final String address;

    @JsonCreator
    public EmailAddress(
            @JsonProperty("name") String name,
            @JsonProperty("address") String address) {
        this.name = name;
        this.address = address;
    }

}
