package com.emailclue.api;

import java.util.HashMap;
import java.util.Map;

public class TemplateDataBuilder {
    
    private Map<String, Object> data;

    private TemplateDataBuilder(Map<String, Object> data) {
        data = data;
    }

    public static TemplateDataBuilder empty() {
        return new TemplateDataBuilder(new HashMap<String, Object>());
    }

    public static TemplateDataBuilder map(Map<String, Object> data) {
        return new TemplateDataBuilder(data);
    }

    /* protected */ Map<String, Object> build() {
        return data;
    }
}
