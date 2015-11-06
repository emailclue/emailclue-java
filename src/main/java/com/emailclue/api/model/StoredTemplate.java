package com.emailclue.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class StoredTemplate implements Template {

    private final String templateName;
    private final Map<String, Object> data;

    @JsonCreator
    public StoredTemplate(
            @JsonProperty("templateName") String templateName,
            @JsonProperty("data") Map<String, Object> data
    ) {
        this.templateName = templateName;
        this.data = data;
    }

    public String getTemplateName() {
        return templateName;
    }

    public Map<String, Object> getData() {
        return data;
    }

}
