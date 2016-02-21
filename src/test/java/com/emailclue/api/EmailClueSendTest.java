package com.emailclue.api;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.google.common.collect.ImmutableMap;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import java.util.Map;

import static com.emailclue.api.EmailClue.configuration;
import static com.emailclue.api.EmailClue.fromTemplate;
import static com.emailclue.api.Util.fixture;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.equalToJson;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.verify;

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
    @Ignore
    public void canSendEmail() {

        stubFor(post(urlEqualTo("/v1/email/message/send"))
                .willReturn(aResponse()
                        .withHeader("MediaType", "application/json")
                        .withBody("{}")));

        Map<String, Object> templateData = ImmutableMap.<String, Object>builder()
                .put("name", "Homer")
                .build();

        emailClueClient.sendEmail(
                fromTemplate("TEMPLATE101")
                        .to("recipient@example.com")
                        .cc("cc@example.com")
                        .subject("Test Email")
                        .templateData(ImmutableMap.<String, Object>of(
                                "toName", "Daniel",
                                "contact", ImmutableMap.of(
                                        "name", "James",
                                        "url", "http://google.com"
                                )
                        )));

        verify(postRequestedFor(urlEqualTo("/v1/email/message/send"))
                .withHeader("Authorization", equalTo("Bearer 12873782347TOKEN"))
        .withRequestBody(equalToJson(fixture("response/send.json"))));
    }

}
