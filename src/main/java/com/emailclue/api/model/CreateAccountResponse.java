package com.emailclue.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateAccountResponse {

    private final Clue clue;
    private final String apiToken;

    @JsonCreator
    public CreateAccountResponse(
            @JsonProperty("apiToken") String apiToken,
            @JsonProperty("clue") Clue clue) {
        this.apiToken = apiToken;
        this.clue = clue;
    }

    public Clue getClue() {
        return clue;
    }

    public String getApiToken() {
        return apiToken;
    }

}
