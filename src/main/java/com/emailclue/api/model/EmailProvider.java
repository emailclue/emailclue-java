package com.emailclue.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailProvider {

    private final String name;
    private final String loginURL;
    private final String logoURL;

    @JsonCreator
    public EmailProvider(
            @JsonProperty("name") String name,
            @JsonProperty("loginURL") String loginURL,
            @JsonProperty("logoURL") String logoURL
    ) {
        this.name = name;
        this.loginURL = loginURL;
        this.logoURL = logoURL;
    }

    public String getName() {
        return name;
    }

    public String getLoginURL() {
        return loginURL;
    }

    public String getLogoURL() {
        return logoURL;
    }

}
