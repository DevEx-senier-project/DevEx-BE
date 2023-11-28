package com.DevEx.DevExBE.domain.corporation;

import com.DevEx.DevExBE.domain.corporation.dto.CorporationRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/corporation")
@Tag(name = "[6] Corporation", description = "Corporation API")
public class CorporationController {

    private final CorporationService corporationService;

    @Operation(summary = "회사 추가", description = "회사 추가")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> addCorporation(@RequestPart(value = "file", required = false) MultipartFile multipartFile,
                                            @RequestPart(value = "corporationRequestDto") CorporationRequestDto corporationRequestDto) throws IOException {
        corporationService.addCorporation(corporationRequestDto, multipartFile);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @Operation(summary = "회사 전체 조회", description = "회사 전체 조회")
    @GetMapping
    public ResponseEntity<?> getCorporationList() {
        try {
            return new ResponseEntity<>(corporationService.getCorporationList(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Corporation not exists");
        }
    }

    @Operation(summary = "Id로 회사 조회", description = "Id로 회사 조회")
    @GetMapping("/{corp_id}")
    public ResponseEntity<?> getCorporation(@PathVariable("corp_id") Long corp_id) {
        return new ResponseEntity<>(corporationService.getCorporation(corp_id), HttpStatus.OK);
    }

    //프로필 이미지 수정
    @PostMapping(path = "/profile/file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> updateProfileImage(@RequestParam("file") MultipartFile multipartFile, @RequestParam("corpName") String corpName)
            throws IOException {
        return new ResponseEntity<>(corporationService.uploadFile(corpName, multipartFile), HttpStatus.OK);
    }
}
