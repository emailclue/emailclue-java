package com.emailclue.api;

import com.emailclue.api.model.Clue;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

public class ValidationBuilder {

    private final String email;

    private ValidationBuilder(String email) {
        this.email = email;
    }

    public static ValidationBuilder email(String email) {
        return new ValidationBuilder(email);
    }


    public Clue invoke(EmailClueConfig configuration) {
        return configuration.getWebTarget()
                .path("/email/address/{emailAddress}/status")
                .resolveTemplate("emailAddress", email)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + configuration.apiKey)
                .get(Clue.class);
    }

}
