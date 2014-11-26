package com.emailclue.api.builder.action;

import com.emailclue.api.model.response.Clue;

public class ValidationBuilder {

    private ValidationBuilder() {
    }

    public static ValidationBuilder email(String email) {
        return new ValidationBuilder();
    }


    public Clue invoke() {
        return null;
    }
}
