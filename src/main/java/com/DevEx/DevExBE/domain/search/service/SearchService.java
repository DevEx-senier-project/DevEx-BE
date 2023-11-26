package com.DevEx.DevExBE.domain.search.service;

import com.DevEx.DevExBE.API.Dto.UserQuoteRequestDto;
import com.DevEx.DevExBE.API.FedexService;
import com.DevEx.DevExBE.domain.corporation.CorporationService;
import com.DevEx.DevExBE.domain.corporation.dto.CorpResponseDto;
import com.DevEx.DevExBE.domain.handcarry.Handcarry;
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

        //페덱스에 api 요청보낸 결과 받아오기
        FedexToResponse fedexToResponse = getFedexToResponse(userQuoteRequestDto);

        //페덱스 결과 추가
        resultArray.add(SearchQuoteResponseDto.toDto(Float.parseFloat(fedexToResponse.getCost()), CorpResponseDto.toFedexDto()));

        // TODO: 2023-11-22 [공준우] 금지품목 검사 추가
        //핸즈캐리 결과 추가
        handcarryService.getHandcarryByStartPointAndEndPoint(userQuoteRequestDto)
                .forEach(handcarry
                        -> resultArray.add(getDto(userQuoteRequestDto.getWeight(), handcarry)));

        return resultArray;
    }

    private FedexToResponse getFedexToResponse(UserQuoteRequestDto userQuoteRequestDto) {
        JsonObject jsonObject = fedexService.postFedexQuote(userQuoteRequestDto);
        return new FedexToResponse(jsonObject);
    }


    private SearchQuoteResponseDto getDto(int weight, Handcarry handcarry) {
        return SearchQuoteResponseDto.toDto(
                handcarry.getUnitCosts() * weight, CorpResponseDto.toDto(handcarry.getCorporation()));
    }

}
