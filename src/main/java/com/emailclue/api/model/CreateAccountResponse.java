package com.emailclue.api.model;

public class CreateAccountResponse {

    private final Clue clue;
    private final String apiToken;

    public CreateAccountResponse(String apiToken, Clue clue) {
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
