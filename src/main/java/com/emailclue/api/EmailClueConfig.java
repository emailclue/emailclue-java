package com.emailclue.api;

import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class EmailClueConfig {

    public final String target;
    private final String basePath;
    public final String apiKey;
    private final Client client;

    private EmailClueConfig(Builder builder) {
        target = builder.target;
        basePath = builder.basePath;
        apiKey = builder.apiKey;
        if (builder.client != null) {
            this.client = builder.client;
        } else {
            this.client = defaultJerseyClient();
        }
    }

    private Client defaultJerseyClient() {
        return ClientBuilder.newClient()
                .register(JacksonFeature.class);
    }

    public static Builder configuration() {
        return new Builder();
    }

    public WebTarget getWebTarget() {
        return client.target(target + basePath);
    }


    public static final class Builder {

        // TODO use https
        private String target = "http://api.emailclue.com";
        private String basePath = "/v1";
        private String apiKey;
        private Client client;

        private Builder() {
        }

        public Builder host(String host) {
            this.target = host;
            return this;
        }

        public Builder basePath(String basePath) {
            this.basePath = basePath;
            return this;
        }

        public Builder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public Builder client(Client client) {
            this.client = client;
            return this;
        }

        public EmailClueConfig build() {
            return new EmailClueConfig(this);
        }
    }
}
