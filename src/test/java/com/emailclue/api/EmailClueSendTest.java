package com.emailclue.api;

import com.emailclue.api.model.response.EmailSent;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Before;
import org.junit.Rule;

import static com.emailclue.api.EmailClue.configuration;
import static com.emailclue.api.EmailClue.emailClueClient;
import static com.emailclue.api.EmailClue.fromTemplate;
import static com.emailclue.api.EmailClue.templateData;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

public class EmailClueSendTest {


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


    public void canSendEmail() {

        stubFor(post(urlEqualTo("/email/send"))
                .willReturn(aResponse()
                        .withBody("{}")));

        EmailSent emailSent = emailClueClient.sendEmail(
                fromTemplate("TEMPLATE101")
                        .to("dj.mabbett@gmail.com")
                        .cc("triumph_2500@hotmail.com")
                        .subject("Test Email")
                        .data(templateData()));
    }

}
