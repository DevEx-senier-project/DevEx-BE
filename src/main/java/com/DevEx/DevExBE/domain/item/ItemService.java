package com.DevEx.DevExBE.domain.item;

import com.DevEx.DevExBE.domain.item.dto.ItemRequestDto;
import com.DevEx.DevExBE.domain.item.dto.ItemResponseDto;
import com.DevEx.DevExBE.global.exception.item.ItemAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemResponseDto addItem(ItemRequestDto requestDto) throws Exception {
        if (itemRepository.existsByItemName(requestDto.getItemName())) {
            throw new ItemAlreadyExistsException();
        }
        Item savedItem = itemRepository.save(requestDto.toEntity());
        return ItemResponseDto.toDto(savedItem);
    }

    public List<ItemResponseDto> getItemListByCategory(ItemRequestDto requestDto) {
        return itemRepository.findByCategory(requestDto.toEntity().getCategory()).stream()
                .map(ItemResponseDto::toDto).toList();
    }

    // TODO: 2023-11-27 [공준우] 예외처리
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    public List<Item> getItemList(List<String> itemNames) {
        return itemRepository.findByItemNameIn(itemNames);
    }
}