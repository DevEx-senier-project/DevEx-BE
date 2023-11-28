package com.DevEx.DevExBE.domain.handcarry;

import com.DevEx.DevExBE.API.Dto.UserQuoteRequestDto;
import com.DevEx.DevExBE.domain.banneditem.BannedItemService;
import com.DevEx.DevExBE.domain.corporation.Corporation;
import com.DevEx.DevExBE.domain.corporation.CorporationRepository;
import com.DevEx.DevExBE.domain.corporation.dto.CorporationRequestDto;
import com.DevEx.DevExBE.domain.handcarry.dto.HandcarryRequestDto;
import com.DevEx.DevExBE.domain.handcarry.dto.HandcarryResponseDto;
import com.DevEx.DevExBE.domain.item.ItemService;
import com.DevEx.DevExBE.global.S3.BucketDir;
import com.DevEx.DevExBE.global.S3.S3Service;
import com.DevEx.DevExBE.global.exception.corporation.CorporationAlreadyExistsException;
import com.DevEx.DevExBE.global.exception.handcarry.HandcarryNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
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
    private final S3Service s3Service;
    private final String defaultImage = "https://devex-profile.s3.ap-northeast-2.amazonaws.com/default.png";

    @Transactional
    public HandcarryResponseDto addHandcarry(HandcarryRequestDto requestDto, MultipartFile multipartFile) throws IOException {

        // TODO: 2023-11-27 [공준우] service에 책임 위임
        Corporation corporation = corporationRepository.findByCorpName(requestDto.getCorporation())
                .orElseThrow(HandcarryNotFoundException::new);

        String imageUrl = defaultImage;
        if (multipartFile != null) {
            imageUrl = s3Service.uploadFile(BucketDir.HandCarry, multipartFile);
        }
        Handcarry savedHandCarry = handcarryRepository.save(Handcarry.toEntity(requestDto, corporation, imageUrl));

        //bannedItem 저장
        bannedItemService.addBannedItem(requestDto.getBannedItemList(), savedHandCarry);
        return HandcarryResponseDto.toDto(savedHandCarry);
    }


    public List<HandcarryResponseDto> getHandcarry() {
        return handcarryRepository.findAll().stream().map(
                HandcarryResponseDto::toDto
        ).toList();
    }


    public ResponseEntity<Void> updateHandcarry(Long handcarryId, HandcarryRequestDto handcarryRequestDto) {
        Optional<Handcarry> handcarry = handcarryRepository.findById(handcarryId);
        String newfatmanName = handcarryRequestDto.getStartPoint();
        String newEndPorint = handcarryRequestDto.getEndPoint();
        Float newUnitCost = handcarryRequestDto.getUnitCosts();
        Long newMaxWeight = handcarryRequestDto.getMaxWeight();

        handcarry.get().update(newfatmanName, newEndPorint, newUnitCost, newMaxWeight);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    public ResponseEntity<Void> deleteHandcarry(Long id) {
        handcarryRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public List<Handcarry> getHandcarryByStartPointAndEndPoint(UserQuoteRequestDto userQuoteRequestDto) {
        return handcarryRepository.findByStartPointAndEndPoint(userQuoteRequestDto.getShipperCountryCode(), userQuoteRequestDto.getRecipientCountryCode());
    }

    public String uploadFile(Long id, MultipartFile multipartFile) throws IOException {
        Optional<Handcarry> handcarry = handcarryRepository.findById(id);
        String newProfileUrl = s3Service.uploadFile(BucketDir.HandCarry, multipartFile);
        handcarry.get().changeProfileImageUrl(newProfileUrl);
        handcarryRepository.save(handcarry.get());
        return newProfileUrl;
    }

}
