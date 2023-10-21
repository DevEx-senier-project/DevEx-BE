package com.DevEx.DevExBE.domain.item.dto;

import com.DevEx.DevExBE.domain.item.Item;

public class ItemRequestDto {
    private String itemName;
    private String category;

    public Item toEntity(){
        return Item.builder()
                .itemName(itemName)
                .category(category)
                .build();
    }
}
