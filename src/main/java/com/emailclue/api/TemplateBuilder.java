package com.emailclue.api;

import com.emailclue.api.model.StoredTemplate;
import com.emailclue.api.model.Template;

import java.util.HashMap;
import java.util.Map;

public abstract class TemplateBuilder {

    protected Map<String, Object> data = new HashMap<>();

    public static StoredTemplateBuilder storedTemplate(String templateId) {
        return new StoredTemplateBuilder(templateId);
    }

    public TemplateBuilder data(Map<String, Object> data) {
        this.data = data;
        return this;
    }

    /* protected */ abstract Template build();



    public static class StoredTemplateBuilder extends TemplateBuilder {

        private final String templateId;

        public StoredTemplateBuilder(String templateId) {
            this.templateId = templateId;
        }

        @Override
        Template build() {
            return new StoredTemplate(templateId, data);
        }
    }


}
