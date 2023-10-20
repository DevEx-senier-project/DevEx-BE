package com.DevEx.DevExBE.domain.handcarry.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HandcarryResponseDto {
    private String startPoint;
    private String endPoint;
    private Long unitCosts;
    private Long maxWeight;
}
