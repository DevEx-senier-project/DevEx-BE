package com.DevEx.DevExBE.domain.search.dto;

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
    private String corporation;

    private Float cost;

    public static SearchQuoteResponseDto toDto(String cost, String corporation) {
        return SearchQuoteResponseDto.builder()
                .cost(Float.parseFloat(cost))
                .corporation(corporation)
                .build();
    }

}
