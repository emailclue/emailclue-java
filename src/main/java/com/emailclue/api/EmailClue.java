package com.emailclue.api;

import com.emailclue.api.builder.action.SendEmailBuilder;
import com.emailclue.api.builder.action.ValidationBuilder;
import com.emailclue.api.builder.data.RecipientBuilder;
import com.emailclue.api.builder.data.TemplateDataBuilder;
import com.emailclue.api.model.response.Clue;
import com.emailclue.api.model.response.EmailSent;

public class EmailClue {

    private final EmailClueConfig configuration;

    private EmailClue(EmailClueConfig configuration) {
        this.configuration = configuration;
    }
//    public final String API_TOKEN;

//    private EmailClue(String api_token) {
//        API_TOKEN = api_token;
//    }


    public static EmailClue emailClue(String apiKey) {
        return emailClue(EmailClueConfig.configuration().apiKey(apiKey));
    }

    public static EmailClue emailClue(EmailClueConfig.Builder configuration) {
        return new EmailClue(configuration.build());
    }


    // Operations
    public Clue validate(ValidationBuilder validationBuilder) {
        return validationBuilder.invoke(configuration);
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

    public static EmailClueConfig.Builder configuration() {
        return EmailClueConfig.configuration();
    }

    public static ValidationBuilder email(String email) {
        return ValidationBuilder.email(email);
    }


}
