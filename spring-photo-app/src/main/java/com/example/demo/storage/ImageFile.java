package com.example.demo.storage;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageFile {

    private String fileId;
    private String fileName;
    private String fileType;
    private Long fileSize;
    private String filePath;

    @Builder
    public ImageFile(String fileId, String fileName, String fileType, Long fileSize, String filePath) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileSize = fileSize;
        this.filePath = filePath;
    }
}