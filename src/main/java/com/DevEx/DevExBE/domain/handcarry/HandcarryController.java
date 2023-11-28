package com.DevEx.DevExBE.domain.handcarry;


import com.DevEx.DevExBE.domain.handcarry.dto.HandcarryRequestDto;
import com.DevEx.DevExBE.domain.handcarry.dto.HandcarryResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/Handcarry")
@Tag(name = "[4] Handcarry", description = "Handcarry API")
public class HandcarryController {

    private final HandcarryService handcarryService;

    // TODO: 2023-11-28 [공준우] 중복된 핸드캐리가 있을 경우 예외처리
    @Operation(summary = "핸드캐리 추가", description = "핸드캐리 추가")
    @PostMapping
    public ResponseEntity<HandcarryResponseDto> addHandCarry(@RequestBody HandcarryRequestDto handRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(handcarryService.addHandcarry(handRequestDto));
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
}
