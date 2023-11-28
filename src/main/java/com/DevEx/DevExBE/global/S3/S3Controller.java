package com.DevEx.DevExBE.global.S3;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.function.ToDoubleBiFunction;

@RestController
@RequestMapping("/S3")
@RequiredArgsConstructor
public class S3Controller {
    private final S3Service s3Service;

    // TODO: 2023/11/28 주어진 버킷이름 없을 시 예외 처리 
    @PostMapping
    public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("bucket") String bucket) throws IOException {
        BucketDir bucketDir = BucketDir.valueOf(bucket);
        return s3Service.uploadFile(bucketDir, file);
    }


    // TODO: 2023/11/27 파일 이름 지정, 파일 이름으로 찾아오기(클라이언트에게 전달)
}
