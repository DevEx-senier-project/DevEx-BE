package com.DevEx.DevExBE.domain.banneditem.dto;

import com.DevEx.DevExBE.domain.banneditem.BannedItem;
import com.DevEx.DevExBE.domain.handcarry.Handcarry;
import com.DevEx.DevExBE.domain.handcarry.dto.HandcarryRequestDto;
import com.DevEx.DevExBE.domain.item.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BannedItemRequestDto {
    public BannedItem toEntity(Item item, Handcarry handcarry){
        return BannedItem.builder()
                .item(item)
                .handCarry(handcarry)
                .build();
    }
}
