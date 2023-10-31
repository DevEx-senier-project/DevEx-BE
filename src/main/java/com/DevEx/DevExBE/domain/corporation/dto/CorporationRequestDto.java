package com.DevEx.DevExBE.domain.corporation.dto;

import com.DevEx.DevExBE.domain.corporation.Corporation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CorporationRequestDto {
    private String name;
    private String email;
    private String tell;

    public Corporation toEntity(){
        return Corporation.builder()
                .corpName(name)
                .email(email)
                .tell(tell)
                .build();
    }
}
