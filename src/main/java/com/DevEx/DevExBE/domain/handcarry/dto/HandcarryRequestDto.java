package com.DevEx.DevExBE.domain.handcarry.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class HandcarryRequestDto {

    @Schema(example = "KR", description = "출발 국가 코드")
    private String startPoint;

    @Schema(example = "CH", description = "도착 국가 코드")
    private String endPoint;

    @Schema(example = "10", description = "무게당 비용")
    private Float unitCosts;

    @Schema(example = "100", description = "최대 무게")
    private Long maxWeight;

    @Schema(example = "삼성성", description = "회사 이름")
    private String corporation;

    @Schema(example = "[\"cook_book\",\"요리비책\"]", description = "출발 국가 코드")
    private List<String> bannedItemList;

    @Schema(example = "3", description = "예상 배송 소요일")
    private int expectedDate;

}