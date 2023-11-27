package com.DevEx.DevExBE.domain.item.dto;

import com.DevEx.DevExBE.domain.item.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ItemResponseDto {

    private String category;

    private String itemName;

    public static ItemResponseDto toDto(Item item) {
        return ItemResponseDto.builder()
                .category(item.getCategory())
                .itemName(item.getItemName())
                .build();
    }
}
