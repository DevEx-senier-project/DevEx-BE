package com.DevEx.DevExBE.domain.banneditem;

import com.DevEx.DevExBE.domain.handcarry.Handcarry;
import com.DevEx.DevExBE.domain.item.Item;
import com.DevEx.DevExBE.domain.item.ItemRepository;
import com.DevEx.DevExBE.domain.item.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// TODO: 2023-10-23 1. banneditem 수정 기능 추가
@RequiredArgsConstructor
@Service
public class BannedItemService {
    private final BannedItemRepository bannedItemRepository;
    private final ItemRepository itemRepository;
    private final ItemService itemService;


    //itemNames으로 Item 찾아서 bannedItem에 저장
    public void addBannedItem(List<String> ItemList, Handcarry handcarry) {

        try{

            List<Item> itemList = itemService.getItemList(ItemList);

            for (Item item : itemList) {
                bannedItemRepository.save(BannedItem.toEntity(item, handcarry));
            }

        }
        catch (Exception e){
            System.out.println("error");
        }

    }

}
