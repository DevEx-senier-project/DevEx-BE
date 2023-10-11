package com.DevEx.DevExBE.API.Contrller;

import com.DevEx.DevExBE.API.FedexService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/fedex")
public class FedexController {

        private final FedexService fedexService;

        @GetMapping("/token")
        public String getFedexTest() {
            return fedexService.getFedexToken();
        }
}
