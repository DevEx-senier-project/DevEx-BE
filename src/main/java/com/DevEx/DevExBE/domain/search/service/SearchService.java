package com.DevEx.DevExBE.domain.search.service;

import com.DevEx.DevExBE.API.Dto.UserQuoteRequestDto;
import com.DevEx.DevExBE.API.FedexService;
import com.DevEx.DevExBE.domain.corporation.CorporationService;
import com.DevEx.DevExBE.domain.handcarry.HandcarryRepository;
import com.DevEx.DevExBE.domain.handcarry.HandcarryService;
import com.DevEx.DevExBE.domain.search.converter.FedexToResponse;
import com.DevEx.DevExBE.domain.search.dto.SearchQuoteResponseDto;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SearchService {

    private final FedexService fedexService;
    private final CorporationService corporationService;
    private final HandcarryService handcarryService;

    // TODO: 2023-11-09 [공준우] 코드 컨벤션 맟추기 
    public List<SearchQuoteResponseDto> search(UserQuoteRequestDto userQuoteRequestDto) {

        List<SearchQuoteResponseDto> resultArray = new ArrayList<>();

        JsonObject jsonObject = fedexService.postFedexQuote(userQuoteRequestDto);
        FedexToResponse fedexToResponse = new FedexToResponse(jsonObject);
        resultArray.add(SearchQuoteResponseDto.toDto(fedexToResponse.getCost(), "Fedex"));


        handcarryService.getHandcarryByStartPointAndEndPoint(userQuoteRequestDto.getShipperCountryCode(), userQuoteRequestDto.getRecipientCountryCode())
                .forEach(handcarry -> {

                    resultArray.add(SearchQuoteResponseDto.toDto(
                            Float.toString(handcarry.getUnitCosts() * userQuoteRequestDto.getWeight())
                            , handcarry.getCorporation().getCorpName()));
                });

        return resultArray;
    }

}
