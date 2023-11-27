package com.DevEx.DevExBE.domain.handcarry;


import com.DevEx.DevExBE.domain.handcarry.dto.HandcarryRequestDto;
import com.DevEx.DevExBE.domain.handcarry.dto.HandcarryResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/Handcarry")
public class HandcarryController {

    private final HandcarryService handcarryService;

    @PostMapping
    public ResponseEntity<HandcarryResponseDto> addHandCarry(@RequestBody HandcarryRequestDto handRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(handcarryService.addHandcarry(handRequestDto));
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
}
