package com.emailclue.api;

import com.emailclue.api.builder.SendEmailBuilder;
import com.emailclue.api.builder.TemplateDataBuilder;
import com.emailclue.api.model.response.EmailSent;

public class EmailClue {

    public final String API_TOKEN;

    private EmailClue(String api_token) {
        API_TOKEN = api_token;
    }

    public static EmailClue emailClueClient(String apiKey) {
        return new EmailClue(apiKey);
    }

    public EmailSent sendEmail(SendEmailBuilder sendEmailBuilder) {
        return sendEmailBuilder.invoke();
    }

    public static SendEmailBuilder fromTemplate(String templateId) {
        return SendEmailBuilder.fromTemplate(templateId);
    }

    public static TemplateDataBuilder templateData() {
        return TemplateDataBuilder.empty();
    }

}
