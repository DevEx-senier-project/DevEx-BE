package com.DevEx.DevExBE.domain.handcarry.dto;

import com.DevEx.DevExBE.domain.corporation.Corporation;
import com.DevEx.DevExBE.domain.handcarry.Handcarry;
import com.DevEx.DevExBE.domain.item.Item;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HandcarryResponseDto {

    private String startPoint;

    private String endPoint;

    private Float unitCosts;

    private Long maxWeight;

    private String corporation;

    private List<Item> bannedItemList;

    public static HandcarryResponseDto toDto(Handcarry handcarry) {
        return HandcarryResponseDto.builder()
                .startPoint(handcarry.getStartPoint())
                .endPoint(handcarry.getEndPoint())
                .unitCosts(handcarry.getUnitCosts())
                .maxWeight(handcarry.getMaxWeight())
                .corporation(handcarry.getCorporation().getCorpName())
                .build();
    }
}
