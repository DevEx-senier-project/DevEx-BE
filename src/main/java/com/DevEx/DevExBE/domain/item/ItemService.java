package com.DevEx.DevExBE.domain.item;

import com.DevEx.DevExBE.domain.item.dto.ItemRequestDto;
import com.DevEx.DevExBE.global.exception.item.ItemAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public Item addItem(ItemRequestDto requestDto) throws Exception {
        if (itemRepository.findByItemName(requestDto.getItemName()) != null){
            throw new ItemAlreadyExistsException();
        }

        return itemRepository.save(requestDto.toEntity());
    }

    public List<Item> getItemListByCategory(ItemRequestDto requestDto){
        return itemRepository.findByCategory(requestDto.toEntity().getCategory());
    }

    public ResponseEntity<Void> deleteItem(Long id){
        itemRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public List<Item> getItemList(List<String> itemNames){
        return itemRepository.findByItemNameIn(itemNames);
    }
}