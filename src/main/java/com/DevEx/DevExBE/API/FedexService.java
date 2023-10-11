package com.DevEx.DevExBE.API;

import com.DevEx.DevExBE.API.Entity.Fedex.Token;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class FedexService {

    WebClient dhlWebClient = WebClient.builder()
            .baseUrl("https://apis.fedex.com")
            .build();
    @Value("${API.Fedex.grant_type}")
    private String grant_type;
    @Value("${API.Fedex.client_id}")
    private String client_id;
    @Value("${API.Fedex.client_secret}")
    private String client_secret;

    /***
     * Fedex API를 통해 access토큰을 받아온다.
     * @return String
     */
    public String getFedexToken() {

        Mono<Token> testClient = dhlWebClient.post()
                .uri("/oauth/token")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData("grant_type", grant_type)
                        .with("client_id", client_id)
                        .with("client_secret", client_secret))
                .retrieve()
                .bodyToMono(Token.class);

        return testClient.block().getAccess_token();
    }
}
