package com.emailclue.api;

public class SendEmailFromTemplateBuilder extends SendEmailBuilder {

    public SendEmailFromTemplateBuilder(String templateId) {
        templateBuilder = TemplateBuilder.storedTemplate(templateId);
    }


}
