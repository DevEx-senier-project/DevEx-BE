package com.DevEx.DevExBE.domain.corporation;

import com.DevEx.DevExBE.domain.corporation.dto.CorporationRequestDto;
import jakarta.persistence.EntityExistsException;
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

    /*
    같은 이름을 가진 기업 등록 불가
     */
    @PostMapping
    public ResponseEntity<String> addCorporation(@RequestBody CorporationRequestDto corporationRequestDto) {
        try {
            corporationService.addCorporation(corporationRequestDto);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Corporation exists");
        }
    }


    //전체 기업 조회
    @GetMapping
    public List<Corporation> getCorporationList(){
        return corporationService.getCorporationList();
    }

    //특정 기업 조회
    @GetMapping("/{corp_id}")
    public Optional<Corporation> getCorporation(@PathVariable("corp_id") Long corp_id){
        return corporationService.getCorporation(corp_id);
    }
}
