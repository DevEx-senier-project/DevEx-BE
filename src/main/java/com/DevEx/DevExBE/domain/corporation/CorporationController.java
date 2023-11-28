package com.DevEx.DevExBE.domain.corporation;

import com.DevEx.DevExBE.domain.corporation.dto.CorporationRequestDto;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/corporation")
public class CorporationController {

    private final CorporationService corporationService;
    private String defaultImage = "https://devex-profile.s3.ap-northeast-2.amazonaws.com/default.png";
    /*
    같은 이름을 가진 기업 등록 불가
     */
    @PostMapping
    public ResponseEntity<?> addCorporation(@RequestBody CorporationRequestDto corporationRequestDto) {
        corporationService.addCorporation(corporationRequestDto, defaultImage);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    //전체 기업 조회
    @GetMapping
    public ResponseEntity<?> getCorporationList(){
        try{
            return new ResponseEntity<>(corporationService.getCorporationList(), HttpStatus.OK);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Corporation not exists");
        }
    }

    //특정 기업 조회
    @GetMapping("/{corp_id}")
    public ResponseEntity<?> getCorporation(@PathVariable("corp_id") Long corp_id){
        return new ResponseEntity<>(corporationService.getCorporation(corp_id), HttpStatus.OK);
    }

    //프로필 이미지 등록
    @PostMapping("/profile/file")
    public ResponseEntity<String> uploadFiles(@RequestParam("file") MultipartFile multipartFile)
            throws IOException {
        return new ResponseEntity<>(corporationService.uploadFile( multipartFile), HttpStatus.OK);
    }
}
