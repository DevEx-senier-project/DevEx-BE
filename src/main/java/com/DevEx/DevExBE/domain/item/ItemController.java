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
    public ResponseEntity<?> addItem(@RequestBody ItemRequestDto requestDto) throws Exception {
        itemService.addItem(requestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // TODO: 2023-11-19 [공준우] RequestBody 불필요
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
