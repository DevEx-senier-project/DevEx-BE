package com.DevEx.DevExBE.domain.corporation;

import com.DevEx.DevExBE.domain.corporation.dto.CorporationRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/corporation")
public class CorporationController {

    private final CorporationService corporationService;

    @PostMapping
    public ResponseEntity<Corporation> addCorporation(@RequestBody CorporationRequestDto corporationRequestDto){
        Corporation savedCorp = corporationService.addCorporation(corporationRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedCorp);
    }


    @GetMapping
    public List<Corporation> getCorporationList(@RequestBody CorporationRequestDto corporationRequestDto){
        return corporationService.getCorporationList();
    }

    @GetMapping("/{corp_id}")
    public Optional<Corporation> getCorporation(@PathVariable("corp_id") Long corp_id){
        return corporationService.getCorporation(corp_id);
    }
}
