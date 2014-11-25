package com.emailclue.api;

import com.emailclue.api.model.response.EmailSent;
import org.junit.Test;

import static com.emailclue.api.EmailClue.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class EmailClueTest {

    private final EmailClue emailClueClient = emailClueClient("12873782347TOKEN");

    @Test
    public void canSetAPIToken() {
        assertThat(emailClueClient.API_TOKEN, equalTo("12873782347TOKEN"));
    }

    public void canSendEmail() {
        EmailSent emailSent = emailClueClient.sendEmail(
                fromTemplate("TEMPLATE101")
                        .to("dj.mabbett@gmail.com")
                        .cc("triumph_2500@hotmail.com")
                        .subject("Test Email")
                        .data(templateData()

                        )
        );
    }
}