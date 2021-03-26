package com.example.storage;

import com.example.event.FileEvent;
import com.example.event.FileEventPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class FileService {
    private final FileEventPublisher publisher;

    public void fileUpload(Map<String, Object> data) {
        try {
            log.info("파일 복사 완료");
            log.info("파일 메타 정보 DB 저장 완료");
            FileEvent fileEvent = FileEvent.toCompleteEvent(data);
            publisher.notifyFileEventComplete(fileEvent);
        } catch (Exception e) {
            log.error("파일 업로드 실패", e);
            FileEvent fileEvent = FileEvent.toErrorEvent(data);
            publisher.notifyFileEventError(fileEvent);
        }
    }
}