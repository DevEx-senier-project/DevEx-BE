package com.DevEx.DevExBE.domain.handcarry.dto;

import com.DevEx.DevExBE.domain.handcarry.Handcarry;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class HandcarryRequestDto {

    private String startPoint;

    private String endPoint;

    private Long unitCosts;

    private Long maxWeight;

    public Handcarry toEntity(){
        return Handcarry.builder()
                .startPoint(startPoint)
                .endPoint(endPoint)
                .unitCosts(unitCosts)
                .maxWeight(maxWeight)
                .build();
    }
}