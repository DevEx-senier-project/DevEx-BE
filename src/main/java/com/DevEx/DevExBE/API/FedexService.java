package com.DevEx.DevExBE.API;

import com.DevEx.DevExBE.API.Dto.FedexQuoteRequestDto;
import com.DevEx.DevExBE.API.Dto.UserQuoteRequestDto;
import com.DevEx.DevExBE.API.Util.Token;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class FedexService {

    @Value("${API.Fedex.grant_type}")
    private String grant_type;
    @Value("${API.Fedex.client_id}")
    private String client_id;
    @Value("${API.Fedex.client_secret}")
    private String client_secret;

    WebClient dhlWebClient = WebClient.builder()
            .baseUrl("https://apis.fedex.com")
            .build();

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

    // TODO: 2023-10-22 1. bodyValue에 넣을 객체 test -> 실제 값으로 바꾸기 (2023-10-23 완료)
    public JsonObject postFedexQuote(UserQuoteRequestDto userQuoteRequestDto) {

        //bodyValue에 넣을 객체
        FedexQuoteRequestDto QuoteRequest = new FedexQuoteRequestDto(userQuoteRequestDto);

        String testClient = dhlWebClient.post()
                .uri("/rate/v1/rates/quotes")
                .contentType(MediaType.APPLICATION_JSON)
                .header("authorization", "Bearer " + getFedexToken())
                .bodyValue(QuoteRequest.getResult())
                .retrieve()
                .bodyToMono(String.class)
                .block();

        JsonParser parser = new JsonParser();
        JsonObject jsonObject = (JsonObject) parser.parse(testClient);

        return jsonObject;
    }
}
