package com.DevEx.DevExBE.domain.corporation;

import com.DevEx.DevExBE.domain.corporation.dto.CorporationRequestDto;
import com.DevEx.DevExBE.domain.users.UserService;
import com.DevEx.DevExBE.domain.users.Users;
import com.DevEx.DevExBE.domain.users.dto.UserRequestDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Corporation> getCorporation(@RequestBody CorporationRequestDto corporationRequestDto){
        Corporation corporation = corporationService.getCorporation(corporationRequestDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(corporation);
    }

}
