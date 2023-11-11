package com.DevEx.DevExBE.domain.handcarry;


import com.DevEx.DevExBE.domain.handcarry.Handcarry;
import com.DevEx.DevExBE.domain.handcarry.HandcarryService;
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
    public ResponseEntity<?> addHandCarry(@RequestBody HandcarryRequestDto handRequestDto){

        try{
            Handcarry savedHand = handcarryService.addHandcarry(handRequestDto);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(savedHand);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }

    }

    @GetMapping
    public List<Handcarry> getHand(){
        return handcarryService.getHandcarry();
    }

    @PutMapping("/{handcarryId}")
    public ResponseEntity<Void> updateHandcarry (@PathVariable Long handcarryId, @ModelAttribute HandcarryRequestDto handcarryRequestDto) {
        handcarryService.updateHandcarry(handcarryId, handcarryRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/{HandId}")
    public ResponseEntity<Void> deleteHand(@PathVariable("HandId") Long handId) {
        handcarryService.deleteHandcarry(handId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
