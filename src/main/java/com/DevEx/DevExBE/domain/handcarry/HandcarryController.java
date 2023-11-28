package com.DevEx.DevExBE.domain.handcarry;


import com.DevEx.DevExBE.domain.corporation.dto.CorporationRequestDto;
import com.DevEx.DevExBE.domain.handcarry.dto.HandcarryRequestDto;
import com.DevEx.DevExBE.domain.handcarry.dto.HandcarryResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/Handcarry")
public class HandcarryController {

    private final HandcarryService handcarryService;

    @PostMapping
    public ResponseEntity<HandcarryResponseDto> addHandCarry(@RequestPart(value = "file", required=false) MultipartFile multipartFile,
                                                             @RequestPart(value = "handcarryRequestDto") HandcarryRequestDto handcarryRequestDto) throws IOException {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(handcarryService.addHandcarry(handcarryRequestDto, multipartFile));
    }

    @GetMapping
    public ResponseEntity<List<HandcarryResponseDto>> getHand() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(handcarryService.getHandcarry());
    }


    // TODO: 2023-11-19 [공준우] api 명세서에 없음
    @PutMapping("/{handcarryId}")
    public ResponseEntity<Void> updateHandcarry(@PathVariable Long handcarryId, @ModelAttribute HandcarryRequestDto handcarryRequestDto) {
        handcarryService.updateHandcarry(handcarryId, handcarryRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // TODO: 2023-11-19 [공준우] api 명세서에 없음
    @DeleteMapping("/{HandId}")
    public ResponseEntity<Void> deleteHand(@PathVariable("HandId") Long handId) {
        handcarryService.deleteHandcarry(handId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //프로필 이미지 수정
    @PutMapping("/profile/file")
    public ResponseEntity<String> updateProfileImage(@RequestParam("file") MultipartFile multipartFile, @RequestParam("handCarryName") Long handCarryId)
            throws IOException {
        return new ResponseEntity<>(handcarryService.uploadFile(handCarryId, multipartFile), HttpStatus.OK);
    }

}
