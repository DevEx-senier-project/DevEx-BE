package com.DevEx.DevExBE.domain.corporation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class CorporationRequestDto {
    private String corpName;
    private String email;
    private String tell;

}
