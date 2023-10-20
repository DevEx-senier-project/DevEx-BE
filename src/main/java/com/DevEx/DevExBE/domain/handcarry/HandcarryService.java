package com.DevEx.DevExBE.domain.handcarry;

import com.DevEx.DevExBE.domain.handcarry.dto.HandcarryRequestDto;
import com.DevEx.DevExBE.domain.handcarry.dto.HandcarryResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class HandcarryService {
    private final HandcarryRepository handcarryRepository;
    public Handcarry addHandcarry(HandcarryRequestDto requestDto){
        return handcarryRepository.save(requestDto.toEntity());
    }


    public Handcarry getHandcarry(HandcarryRequestDto requestDto){
        return handcarryRepository.findById(requestDto.toEntity().getId()).orElseThrow();
    }

    public ResponseEntity<Void> updateHandcarry(Long handcarryId, HandcarryRequestDto handcarryRequestDto){
        Optional<Handcarry> handcarry = handcarryRepository.findById(handcarryId);
        String newfatmanName = handcarryRequestDto.getStartPoint();
        String newEndPorint = handcarryRequestDto.getEndPoint();
        Long newUnitCost = handcarryRequestDto.getUnitCosts();
        Long newMaxWeight = handcarryRequestDto.getMaxWeight();

        handcarry.get().update(newfatmanName, newEndPorint, newUnitCost, newMaxWeight);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    public ResponseEntity<Void> deleteHandcarry(Long id){
        handcarryRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
