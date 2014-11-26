package com.emailclue.api;

import com.emailclue.api.model.response.Clue;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static com.emailclue.api.EmailClue.configuration;
import static com.emailclue.api.EmailClue.email;
import static com.emailclue.api.EmailClue.emailClueClient;
import static com.emailclue.api.Util.fixture;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;


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


    @Test
    public void canValidateEmail() {

        stubFor(post(urlEqualTo("/email/test@example.com/status"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody(fixture("response/validation.json"))));

        Clue validationResult = emailClueClient.validate(
                email("test@example.com")
        );

//        assertThat(validationResult)
//        assertThat()
    }
}