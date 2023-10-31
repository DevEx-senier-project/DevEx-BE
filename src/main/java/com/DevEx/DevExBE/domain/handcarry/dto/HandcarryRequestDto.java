package com.DevEx.DevExBE.domain.handcarry.dto;

import com.DevEx.DevExBE.domain.corporation.Corporation;
import com.DevEx.DevExBE.domain.handcarry.Handcarry;
import com.DevEx.DevExBE.domain.item.Item;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class HandcarryRequestDto {

    private String startPoint;

    private String endPoint;

    private Long unitCosts;

    private Long maxWeight;

    private List<String> bannedItemList;

}