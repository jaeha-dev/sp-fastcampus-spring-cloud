package com.example.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FileEventListener {

    @EventListener
    public void onFileEventHandler(FileEvent fileEvent) {
        log.info("수신된 파일 이벤트 타입: {}, 데이터: {}", fileEvent.getType(), fileEvent.getData());

        if (fileEvent.getType().equals("COMPLETE")) {
            log.info("파일 업로드 성공");
        } else {
            log.info("파일 업로드 실패");
        }
    }
}