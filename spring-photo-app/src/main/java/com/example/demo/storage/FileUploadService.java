package com.example.demo.storage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class FileUploadService {

    private final FileWriter fileWriter;

    public ImageFile upload(MultipartFile sourceFile) {
        String fileId = UUID.randomUUID().toString();
        String filePath = fileWriter.getFilePath(fileId, sourceFile);

        LOG.info("File Path: {}", filePath);
        fileWriter.writeFile(sourceFile, filePath);

        return ImageFile.builder()
                .fileId(fileId)
                .fileName(sourceFile.getName())
                .fileSize(sourceFile.getSize())
                .filePath(filePath)
                .build();
    }
}