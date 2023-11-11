package com.DevEx.DevExBE.domain.handcarry.dto;

import com.DevEx.DevExBE.domain.corporation.Corporation;
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

    private Long unitCosts;

    private Long maxWeight;

    private Corporation corporation;

    private List<Item> bannedItemList;
}
