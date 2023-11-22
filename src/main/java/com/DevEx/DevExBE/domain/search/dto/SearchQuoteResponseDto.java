package com.DevEx.DevExBE.domain.search.dto;

import com.DevEx.DevExBE.domain.corporation.dto.CorpResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SearchQuoteResponseDto {

    // TODO: 2023-11-09 [공준우] 더 많은 속성 추가 
    private CorpResponseDto corporation;

    private Float cost;

    public static SearchQuoteResponseDto toDto(Float cost, CorpResponseDto corporation) {
        return SearchQuoteResponseDto.builder()
                .cost(cost)
                .corporation(corporation)
                .build();
    }

}
