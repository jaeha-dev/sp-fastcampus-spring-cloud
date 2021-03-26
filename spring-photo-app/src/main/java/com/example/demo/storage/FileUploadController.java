package com.example.demo.storage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Api
@RequiredArgsConstructor
@RequestMapping("/v1")
@RestController
public class FileUploadController {

    private final FileUploadService fileUploadService;

    // http://localhost:8000/swagger-ui.html
    @ApiOperation("이미지 파일 업로드")
    @PostMapping("/upload/image")
    public ImageFileUploadResult transfer(@RequestParam("userKey") String userKey,
                                          @RequestPart("imageFile") MultipartFile multipartFile) {

        ImageFile imageFile = fileUploadService.upload(multipartFile);

        return ImageFileUploadResult.builder()
                .fileId(imageFile.getFileId())
                .fileName(imageFile.getFileName())
                .fileSize(imageFile.getFileSize())
                .build();
    }
}