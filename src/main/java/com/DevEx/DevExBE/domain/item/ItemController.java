package com.DevEx.DevExBE.domain.item;


import com.DevEx.DevExBE.domain.item.dto.ItemRequestDto;
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
    public ResponseEntity<Item> addItem(@RequestBody ItemRequestDto requestDto){
        Item item = itemService.addItem(requestDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(item);
    }

    @GetMapping
    public List<Item> getItemList(@RequestBody ItemRequestDto requestDto){
        return itemService.getItemListByCategory(requestDto);
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable("itemId") Long itemId) {
        itemService.deleteItem(itemId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}