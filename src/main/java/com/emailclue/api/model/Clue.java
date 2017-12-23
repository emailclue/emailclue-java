package com.emailclue.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class Clue {

    private final Status status;
    private final ErrorType errorType;
    private final List<String> didYouMean;
    private final EmailProvider emailProvider;
    private final boolean disposable;

    @JsonCreator
    public Clue(
            @JsonProperty("status") final Status status,
            @JsonProperty("errorType") final ErrorType errorType,
            @JsonProperty("didYouMean") final List<String> didYouMean,
            @JsonProperty("emailProvider") final EmailProvider emailProvider,
            @JsonProperty("disposable") boolean disposable
    ) {
        this.status = status;
        this.errorType = errorType;
        this.didYouMean = didYouMean;
        this.emailProvider = emailProvider;
        this.disposable = disposable;
    }

    @JsonProperty("status")
    public Status getStatus() {
        return status;
    }

    @JsonProperty("errorType")
    public ErrorType getErrorType() {
        return errorType;
    }

    @JsonProperty("didYouMean")
    public List<String> getDidYouMean() {
        return didYouMean;
    }

    public EmailProvider getEmailProvider() {
        return emailProvider;
    }

    @JsonProperty("disposable")
    public boolean isDisposable() {
        return disposable;
    }

    @Override
    public String toString() {
        return "Clue{" +
                "status=" + status +
                ", errorType=" + errorType +
                ", didYouMean=" + didYouMean +
                ", emailProvider=" + emailProvider +
                '}';
    }
}
