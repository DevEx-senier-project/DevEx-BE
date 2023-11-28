package com.DevEx.DevExBE.domain.item.dto;

import com.DevEx.DevExBE.domain.item.Item;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ItemRequestDto {

    @Schema(example = "cook_book")
    private String itemName;

    @Schema(example = "Book")
    private String category;

    public Item toEntity(){
        return Item.builder()
                .itemName(itemName)
                .category(category)
                .build();
    }
}
