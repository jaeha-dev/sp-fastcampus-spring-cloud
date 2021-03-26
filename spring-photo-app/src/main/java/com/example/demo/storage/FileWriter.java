package com.example.demo.storage;

import com.example.demo.config.PhotoAppProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RequiredArgsConstructor
@Service
public class FileWriter {

    private final PhotoAppProperties photoAppProperties;

    public long writeFile(MultipartFile multipartFile, String filePath) {
        try {
            // (지정된 경로를 찾을 수 없습니다.) 오류가 발생할 경우,
            // /photo-app/upload 폴더 내에 날짜(20210327) 폴더를 생성한 후에 실행한다.
            multipartFile.transferTo(new File(filePath));
        } catch (IllegalStateException e) {
            throw new RuntimeException("File Write Error", e);
        } catch (IOException e) {
            throw new RuntimeException("IO Error", e);
        }

        return multipartFile.getSize();
    }

    public String getFilePath(String fileId, MultipartFile sourceFile) {
        // 날짜 단위로 파일 ID와 업로드 파일의 확장자로 구분한다.
        return photoAppProperties.getDefaultPath() + "\\" + dateStr() + "\\" + fileId + "." + getMimeType(sourceFile.getOriginalFilename());
    }

    public static String dateStr() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        return now.format(dateTimeFormatter);
    }

    private static String getMimeType(String filePath) {
        return FilenameUtils.getExtension(filePath);
    }
}