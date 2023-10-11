package com.DevEx.DevExBE.API.Contrller;

import com.DevEx.DevExBE.API.Entity.Fedex.TestRequest;
import com.DevEx.DevExBE.API.FedexService;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/fedex")
public class FedexController {

        private final FedexService fedexService;

        @GetMapping("/token")
        public String getFedexToken() {
            return fedexService.getFedexToken();
        }

        @GetMapping("/quote")
        public JsonObject getFedexQuote() {
            return fedexService.postFedexQuote();
        }
}
