package com.DevEx.DevExBE.domain.item;


import com.DevEx.DevExBE.domain.item.dto.ItemRequestDto;
import com.DevEx.DevExBE.domain.item.dto.ItemResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/Item")
@Tag(name = "[7] Item", description = "Item API")
public class ItemController {

    private final ItemService itemService;

    @Operation(summary = "아이템 추가", description = "아이템 추가")
    @PostMapping
    public ResponseEntity<ItemResponseDto> addItem(@RequestBody ItemRequestDto requestDto) throws Exception {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(itemService.addItem(requestDto));
    }

    @Operation(summary = "카테고리로 아이템 조회", description = "카테고리로 아이템 조회")
    @GetMapping
    public ResponseEntity<List<ItemResponseDto>> getItemListByCategory(@RequestBody ItemRequestDto requestDto){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(itemService.getItemListByCategory(requestDto));
    }

    @Operation(summary = "아이템 삭제", description = "아이템 삭제")
    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable("itemId") Long itemId) {
        itemService.deleteItem(itemId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}
