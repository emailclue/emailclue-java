package com.emailclue.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public class EmailSent {

    private final String eventId;

    @JsonCreator()
    public EmailSent(String eventId) {
        this.eventId = eventId;
    }

}
