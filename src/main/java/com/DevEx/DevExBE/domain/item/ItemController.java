package com.DevEx.DevExBE.domain.item;


import com.DevEx.DevExBE.domain.item.dto.ItemRequestDto;
import com.DevEx.DevExBE.domain.item.dto.ItemResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/Item")
public class ItemController {

    private final ItemService itemService;
    @PostMapping
    public ResponseEntity<ItemResponseDto> addItem(@RequestBody ItemRequestDto requestDto) throws Exception {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(itemService.addItem(requestDto));
    }

    // TODO: 2023-11-19 [공준우] RequestBody 불필요
    @GetMapping
    public ResponseEntity<List<ItemResponseDto>> getItemList(@RequestBody ItemRequestDto requestDto){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(itemService.getItemListByCategory(requestDto));
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable("itemId") Long itemId) {
        itemService.deleteItem(itemId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}
