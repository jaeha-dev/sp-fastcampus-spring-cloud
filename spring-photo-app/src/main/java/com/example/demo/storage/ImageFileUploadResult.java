package com.example.demo.storage;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageFileUploadResult {

    private String fileId;
    private String fileName;
    private Long fileSize;

    @Builder
    public ImageFileUploadResult(String fileId, String fileName, Long fileSize) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.fileSize = fileSize;
    }
}