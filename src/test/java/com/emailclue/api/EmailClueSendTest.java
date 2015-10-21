package com.emailclue.api;

import com.emailclue.api.model.response.EmailSent;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static com.emailclue.api.EmailClue.configuration;
import static com.emailclue.api.EmailClue.fromTemplate;
import static com.emailclue.api.EmailClue.templateData;
import static com.emailclue.api.Util.fixture;
import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class EmailClueSendTest {


    private final EmailClue emailClueClient = EmailClue.emailClue(
            configuration()
                    .apiKey("12873782347TOKEN")
                    .host("http://localhost:8089")
    );


    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089);


    @Before
    public void setUp() {

    }

    @Test
    public void canSendEmail() {

        stubFor(post(urlEqualTo("/v1/email/message/send"))
                .willReturn(aResponse()
                        .withHeader("MediaType", "application/json")
                        .withBody("{}")));

        emailClueClient.sendEmail(
                fromTemplate("TEMPLATE101")
                        .to("recipient@example.com")
                        .cc("cc@example.com")
                        .subject("Test Email")
                        .data(templateData()));

        verify(postRequestedFor(urlEqualTo("/v1/email/message/send"))
                .withHeader("Authorization", equalTo("Bearer 12873782347TOKEN"))
        .withRequestBody(equalToJson(fixture("response/send.json"))));
    }

}
