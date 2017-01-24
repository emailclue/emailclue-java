package com.emailclue.api;

import javax.ws.rs.core.MediaType;

class PingBuilder {

    String invoke(EmailClueConfig config) {
        return config.getWebTarget()
                .path("/ping")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .get(String.class);

    }

}
