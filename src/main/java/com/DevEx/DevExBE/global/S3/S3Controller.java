package com.DevEx.DevExBE.global.S3;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.function.ToDoubleBiFunction;

@RestController
@RequestMapping("/S3")
@RequiredArgsConstructor
public class S3Controller {
    private final S3Service s3Service;

    // TODO: 2023/11/28 주어진 Handcarry, Corporation 이미지 관련 예외 처리
    @PostMapping
    public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("bucket") String bucket) throws IOException {
        BucketDir bucketDir = BucketDir.valueOf(bucket);
        return s3Service.uploadFile(bucketDir, file);
    }

}
