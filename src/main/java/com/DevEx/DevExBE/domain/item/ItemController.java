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
    public ResponseEntity<?> addItem(@RequestBody ItemRequestDto requestDto){
        try{
            Item item = itemService.addItem(requestDto);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(item);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("이미 존재하는 아이템입니다.");
        }

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
