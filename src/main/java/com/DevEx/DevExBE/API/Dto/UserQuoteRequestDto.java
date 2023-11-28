package com.DevEx.DevExBE.API.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserQuoteRequestDto {

    //출발 국가 코드
    @Schema(example = "KR" , description = "출발 국가 코드")
    private String shipperCountryCode;

    //출발 우편번호
    @Schema(example = "22212" , description = "출발 우편번호")
    private String shipperPostalCode;

    //도착 국가 코드
    @Schema(example = "CH" , description = "도착 국가 코드")
    private String recipientCountryCode;

    //도착 우편번호
    @Schema(example = "8099" , description = "도착 우편번호")
    private String recipientPostalCode;

    //무게
    @Schema(example = "11" , description = "무게")
    private int weight;

    //무게 단위
    @Schema(example = "KG" , description = "무게 단위")
    private String weightUnit;

    //길이
    //private String length;

    //너비
    //private String width;

    //높이
    //private String height;

    //길이 단위
    //private String dimensionUnit;

}
