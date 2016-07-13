package com.emailclue.api;

import com.emailclue.api.model.Clue;
import com.emailclue.api.model.CreateAccountResponse;

public class EmailClue {

    private final EmailClueConfig configuration;

    private EmailClue(EmailClueConfig configuration) {
        this.configuration = configuration;

    }

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

    public void sendEmail(SendEmailBuilder sendEmailBuilder) {
        sendEmailBuilder.invoke(configuration);
    }

    public CreateAccountResponse createAccount(CreateAccountBuilder createAccountBuilder) {
        return createAccountBuilder.invoke(configuration);
    }


    // Builders
    public static SendEmailFromTemplateBuilder fromTemplate(String templateId) {
        return new SendEmailFromTemplateBuilder(templateId);
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

    public static AttachmentBuilder attachment() {
        return AttachmentBuilder.attachment();
    }

    public static AttachmentBuilder inlineAttachment() {
        return AttachmentBuilder.inlineAttachment();
    }

    public static CreateAccountBuilder account() {
        return CreateAccountBuilder.account();
    }

}
