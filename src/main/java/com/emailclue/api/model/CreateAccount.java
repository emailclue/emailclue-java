package com.emailclue.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateAccount {

    private final String email;
    private final String password;
    private final String captchaResponse;

    @JsonCreator
    public CreateAccount(
            @JsonProperty("email") String email,
            @JsonProperty("password") String password,
            @JsonProperty("captchaResponse") String captchaResponse) {
        this.email = email;
        this.password = password;
        this.captchaResponse = captchaResponse;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCaptchaResponse() {
        return captchaResponse;
    }
}
