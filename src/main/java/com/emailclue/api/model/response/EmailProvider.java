package com.emailclue.api.model.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailProvider {

    private final String name;
    private final String loginURL;
    private final String imageURL;

    @JsonCreator
    public EmailProvider(
            @JsonProperty("name") String name,
            @JsonProperty("loginURL") String loginURL,
            @JsonProperty("imageURL") String imageURL
    ) {
        this.name = name;
        this.loginURL = loginURL;
        this.imageURL = imageURL;
    }

    public String getName() {
        return name;
    }

    public String getLoginURL() {
        return loginURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    @Override
    public String toString() {
        return "EmailProvider{" +
                "name='" + name + '\'' +
                ", loginURL='" + loginURL + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
