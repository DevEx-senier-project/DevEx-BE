package com.DevEx.DevExBE.domain.handcarry;

import com.DevEx.DevExBE.domain.banneditem.BannedItem;
import com.DevEx.DevExBE.domain.banneditem.BannedItemRepository;
import com.DevEx.DevExBE.domain.banneditem.BannedItemService;
import com.DevEx.DevExBE.domain.corporation.Corporation;
import com.DevEx.DevExBE.domain.corporation.CorporationRepository;
import com.DevEx.DevExBE.domain.handcarry.dto.HandcarryRequestDto;
import com.DevEx.DevExBE.domain.handcarry.dto.HandcarryResponseDto;
import com.DevEx.DevExBE.domain.item.Item;
import com.DevEx.DevExBE.domain.item.ItemService;
import com.DevEx.DevExBE.global.exception.handcarry.HandcarryNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class HandcarryService {
    private final HandcarryRepository handcarryRepository;
    private final CorporationRepository corporationRepository;
    private final BannedItemService bannedItemService;
    private final ItemService itemService;


    // TODO: 2023/10/22 Corporation -> Handcarry 간 양방향 매핑
    // TODO: 2023/10/22 Handcarry -> BannedItem 간 양방향 매핑
    // TODO: 2023-11-12 [공준우] 단방향 매핑으로 변경
    public Handcarry addHandcarry(HandcarryRequestDto requestDto) throws Exception {

        try{

            Corporation corporation = corporationRepository.findByCorpName(requestDto.getCorporation())
                    .orElseThrow(HandcarryNotFoundException::new);

            Handcarry savedHandCarry = handcarryRepository.save(Handcarry.toEntity(requestDto, corporation));
            bannedItemService.addBannedItem(requestDto.getBannedItemList(), savedHandCarry);
            return savedHandCarry;
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    // TODO: 2023-10-31 2. BannedItem까지 포함 된 HandcarryResponseDto로 반환

    public List<Handcarry> getHandcarry(){
        return handcarryRepository.findAll();
    }


    public ResponseEntity<Void> updateHandcarry(Long handcarryId, HandcarryRequestDto handcarryRequestDto){
        Optional<Handcarry> handcarry = handcarryRepository.findById(handcarryId);
        String newfatmanName = handcarryRequestDto.getStartPoint();
        String newEndPorint = handcarryRequestDto.getEndPoint();
        Float newUnitCost = handcarryRequestDto.getUnitCosts();
        Long newMaxWeight = handcarryRequestDto.getMaxWeight();

        handcarry.get().update(newfatmanName, newEndPorint, newUnitCost, newMaxWeight);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    public ResponseEntity<Void> deleteHandcarry(Long id){
        handcarryRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public List<Handcarry> getHandcarryByStartPointAndEndPoint(String startPoint, String endPoint){
        return handcarryRepository.findByStartPointAndEndPoint(startPoint, endPoint);
    }

}
