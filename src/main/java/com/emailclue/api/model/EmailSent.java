package com.emailclue.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailSent {

    private final String eventId;

    @JsonCreator()
    public EmailSent(@JsonProperty("eventId") String eventId) {
        this.eventId = eventId;
    }

    public String getEventId() {
        return eventId;
    }

}
