package com.emailclue.api;

import com.emailclue.api.model.response.EmailSent;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Before;
import org.junit.Rule;

import static com.emailclue.api.EmailClue.*;
import static com.github.tomakehurst.wiremock.client.WireMock.*;


public class EmailClueValidateTest {

    private final EmailClue emailClueClient = emailClueClient(
            configuration()
                    .apiKey("12873782347TOKEN")
                    .host("http://localhost:8089")
    );


    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089);


    @Before
    public void setUp() {

    }


    public void canValidateEmail() {

        stubFor(post(urlEqualTo("/email/send"))
                .willReturn(aResponse()
                        .withBody("{}")));

        EmailSent emailSent = emailClueClient.sendEmail(
                fromTemplate("TEMPLATE101")
                        .to("dj.mabbett@gmail.com")
                        .cc("triumph_2500@hotmail.com")
                        .subject("Test Email")
                        .data(templateData()));


//        assertThat()
    }
}