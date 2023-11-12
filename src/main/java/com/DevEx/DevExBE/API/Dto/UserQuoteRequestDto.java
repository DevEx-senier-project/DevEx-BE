package com.DevEx.DevExBE.API.Dto;

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
    private String shipperCountryCode;

    //출발 우편번호
    private String shipperPostalCode;

    //도착 국가 코드
    private String recipientCountryCode;

    //도착 우편번호
    private String recipientPostalCode;

    //무게
    private int weight;

    //무게 단위
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
