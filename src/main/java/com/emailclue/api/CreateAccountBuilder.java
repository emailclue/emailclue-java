package com.emailclue.api;

import com.emailclue.api.model.CreateAccount;
import com.emailclue.api.model.CreateAccountResponse;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import static javax.ws.rs.client.Entity.json;

public class CreateAccountBuilder {

    private String email;
    private String password;
    private String captchaResponse;

    public CreateAccountBuilder() {
    }

    public static CreateAccountBuilder account() {
        return new CreateAccountBuilder();
    }

    public CreateAccountBuilder email(String email) {
        this.email = email;
        return this;
    }

    public CreateAccountBuilder password(String password) {
        this.password = password;
        return this;
    }

    public CreateAccountBuilder captchaResponse(String captchaResponse) {
        this.captchaResponse = captchaResponse;
        return this;
    }

    public CreateAccountResponse invoke(EmailClueConfig configuration) {

        CreateAccount request = new CreateAccount(email, password, captchaResponse);

        return configuration.getWebTarget()
                .path("/tenant")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + configuration.apiKey)
                .post(json(request), CreateAccountResponse.class);

    }
}
