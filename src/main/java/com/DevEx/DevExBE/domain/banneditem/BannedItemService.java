package com.DevEx.DevExBE.domain.banneditem;

import com.DevEx.DevExBE.domain.handcarry.Handcarry;
import com.DevEx.DevExBE.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BannedItemService {
    private final BannedItemRepository bannedItemRepository;

    public void addBannedItem(List<Item> ItemList, Handcarry handcarry) {
        ItemList.stream().map(item -> bannedItemRepository.save(BannedItem.toEntity(item, handcarry)));
    }
}
