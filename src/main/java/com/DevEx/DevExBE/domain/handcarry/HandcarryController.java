package com.DevEx.DevExBE.domain.handcarry;


import com.DevEx.DevExBE.domain.handcarry.dto.HandcarryRequestDto;
import com.DevEx.DevExBE.domain.handcarry.dto.HandcarryResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/Handcarry")
@Tag(name = "[4] Handcarry", description = "Handcarry API")
public class HandcarryController {

    private final HandcarryService handcarryService;

    // TODO: 2023-11-28 [공준우] 중복된 핸드캐리가 있을 경우 예외처리
    @Operation(summary = "핸드캐리 추가", description = "핸드캐리 추가")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<HandcarryResponseDto> addHandCarry(@RequestPart(value = "file", required=false) MultipartFile multipartFile,
                                                             @RequestPart(value = "handcarryRequestDto") HandcarryRequestDto handcarryRequestDto) throws IOException {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(handcarryService.addHandcarry(handcarryRequestDto, multipartFile));
    }

    @Operation(summary = "핸드캐리 전체 조회", description = "핸드캐리 전체 조회")
    @GetMapping
    public ResponseEntity<List<HandcarryResponseDto>> getHand() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(handcarryService.getHandcarry());
    }


    @Operation(summary = "핸드캐리 수정", description = "핸드캐리 수정")
    @PutMapping("/{handcarryId}")
    public ResponseEntity<Void> updateHandcarry(@PathVariable Long handcarryId, @ModelAttribute HandcarryRequestDto handcarryRequestDto) {
        handcarryService.updateHandcarry(handcarryId, handcarryRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "핸드캐리 삭제", description = "핸드캐리 삭제")
    @DeleteMapping("/{HandId}")
    public ResponseEntity<Void> deleteHand(@PathVariable("HandId") Long handId) {
        handcarryService.deleteHandcarry(handId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //프로필 이미지 수정
    @PutMapping(path = "/profile/file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> updateProfileImage(@RequestParam("file") MultipartFile multipartFile, @RequestParam("handCarryName") Long handCarryId)
            throws IOException {
        return new ResponseEntity<>(handcarryService.uploadFile(handCarryId, multipartFile), HttpStatus.OK);
    }

}
