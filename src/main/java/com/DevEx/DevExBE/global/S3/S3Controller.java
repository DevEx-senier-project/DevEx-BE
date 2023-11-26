package com.DevEx.DevExBE.global.S3;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/S3")
@RequiredArgsConstructor
public class S3Controller {
    private final S3Service s3Service;

    @PostMapping
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        BucketDir bucketDir = BucketDir.Image;
        return s3Service.uploadFile(bucketDir, file);
    }

    // TODO: 2023/11/27 파일 이름 지정, 파일 이름으로 찾아오기(클라이언트에게 전달)
}
