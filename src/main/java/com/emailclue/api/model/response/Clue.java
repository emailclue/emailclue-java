package com.emailclue.api.model.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.EnumSet;
import java.util.List;

import static com.emailclue.api.model.response.Status.VALID;
import static com.emailclue.api.model.response.Status.UNKNOW;


public class Clue {

    private static final EnumSet<Status> ACCEPTABLE_STATUS = EnumSet.of(VALID, UNKNOW);

    private final Status status;
    private final long credits;
    private final ErrorType errorType;
    private final List<String> didYouMean;
    private final EmailProvider emailProvider;

    @JsonCreator
    public Clue(
            @JsonProperty("status") final Status status,
            @JsonProperty("credits") long credits,
            @JsonProperty("errorType") final ErrorType errorType,
            @JsonProperty("didYouMean") final List<String> didYouMean,
            @JsonProperty("emailProvider") final EmailProvider emailProvider
    ) {
        this.status = status;
        this.credits = credits;
        this.errorType = errorType;
        this.didYouMean = didYouMean;
        this.emailProvider = emailProvider;
    }

    @JsonProperty("status")
    public Status getStatus() {
        return status;
    }

    @JsonProperty("credits")
    public long getCredits() {
        return credits;
    }

    @JsonProperty("errorType")
    public ErrorType getErrorType() {
        return errorType;
    }

    @JsonProperty("didYouMean")
    public List<String> getDidYouMean() {
        return didYouMean;
    }

    @JsonIgnore
    public boolean isAcceptable() {
        return ACCEPTABLE_STATUS.contains(status);
    }

    public EmailProvider getEmailProvider() {
        return emailProvider;
    }

    @Override
    public String toString() {
        return "Clue{" +
                "status=" + status +
                ", credits=" + credits +
                ", errorType=" + errorType +
                ", didYouMean=" + didYouMean +
                ", emailProvider=" + emailProvider +
                '}';
    }
}
