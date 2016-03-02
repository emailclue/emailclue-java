package com.emailclue.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Tenant {

    private final String email;

    @JsonCreator
    public Tenant(
            @JsonProperty("email") String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

}
