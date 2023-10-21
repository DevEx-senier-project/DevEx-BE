package com.DevEx.DevExBE.domain.banneditem;

import com.DevEx.DevExBE.domain.handcarry.Handcarry;
import com.DevEx.DevExBE.domain.handcarry.HandcarryRepository;
import com.DevEx.DevExBE.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BannedItemService {
    private final BannedItemRepository bannedItemRepository;
    private final ItemRepository itemRepository;
    private final HandcarryRepository handcarryRepository;

}
