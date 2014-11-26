package com.emailclue.api;

public class EmailClueConfiguration {

    public final String host;
    public final String apiKey;

    private EmailClueConfiguration(Builder builder) {
        host = builder.host;
        apiKey = builder.apiKey;
    }

    public static Builder configuration() {
        return new Builder();
    }


    public static final class Builder {

        private String host;
        private String apiKey;

        private Builder() {
        }

        public Builder host(String host) {
            this.host = host;
            return this;
        }

        public Builder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public EmailClueConfiguration build() {
            return new EmailClueConfiguration(this);
        }
    }
}
