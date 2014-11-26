package com.emailclue.api;

import com.emailclue.api.builder.action.SendEmailBuilder;
import com.emailclue.api.builder.action.ValidationBuilder;
import com.emailclue.api.builder.data.RecipientBuilder;
import com.emailclue.api.builder.data.TemplateDataBuilder;
import com.emailclue.api.model.response.Clue;
import com.emailclue.api.model.response.EmailSent;

public class EmailClue {

    private final EmailClueConfiguration configuration;

    private EmailClue(EmailClueConfiguration configuration) {
        this.configuration = configuration;
    }
//    public final String API_TOKEN;

//    private EmailClue(String api_token) {
//        API_TOKEN = api_token;
//    }


    public static EmailClue emailClueClient(String apiKey) {
        return emailClueClient(EmailClueConfiguration.configuration().apiKey(apiKey));
    }

    public static EmailClue emailClueClient(EmailClueConfiguration.Builder configuration) {
        return new EmailClue(configuration.build());
    }


    // Operations
    public Clue validate(ValidationBuilder validationBuilder) {
        return validationBuilder.invoke();
    }

    public EmailSent sendEmail(SendEmailBuilder sendEmailBuilder) {
        return sendEmailBuilder.invoke();
    }


    // Builders
    public static SendEmailBuilder fromTemplate(String templateId) {
        return SendEmailBuilder.fromTemplate(templateId);
    }

    public static TemplateDataBuilder templateData() {
        return TemplateDataBuilder.empty();
    }

    public static RecipientBuilder recipient() {
        return RecipientBuilder.recipient();
    }

    public static EmailClueConfiguration.Builder configuration() {
        return EmailClueConfiguration.configuration();
    }

    public static ValidationBuilder email(String email) {
        return ValidationBuilder.email(email);
    }


}
