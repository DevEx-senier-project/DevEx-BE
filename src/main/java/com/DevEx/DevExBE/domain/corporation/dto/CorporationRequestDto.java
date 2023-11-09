package com.DevEx.DevExBE.domain.corporation.dto;

import com.DevEx.DevExBE.domain.corporation.Corporation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CorporationRequestDto {
    private String corpName;
    private String email;
    private String tell;

}
