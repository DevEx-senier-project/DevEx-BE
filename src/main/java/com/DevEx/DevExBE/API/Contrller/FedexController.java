package com.DevEx.DevExBE.API.Contrller;

import com.DevEx.DevExBE.API.Dto.UserQuoteRequestDto;
import com.DevEx.DevExBE.API.FedexService;
import com.google.gson.JsonObject;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/fedex")
@Hidden
public class FedexController {

    private final FedexService fedexService;


    @GetMapping("/token")
    public String getFedexToken() {
        return fedexService.getFedexToken();
    }

    @GetMapping("/quote")
    public JsonObject getFedexQuote(@RequestBody UserQuoteRequestDto userQuoteRequestDto) {
        return fedexService.postFedexQuote(userQuoteRequestDto);
    }
}
