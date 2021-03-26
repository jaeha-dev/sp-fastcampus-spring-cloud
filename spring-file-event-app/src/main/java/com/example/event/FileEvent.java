package com.example.event;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
public class FileEvent {
    private String id;
    private String type;
    private Map<String, Object> data;

    @Builder
    public FileEvent(String id, String type, Map<String, Object> data) {
        this.id = id;
        this.type = type;
        this.data = data;
    }

    public static FileEvent toCompleteEvent(Map<String, Object> data) {
        return FileEvent.builder()
                .id(UUID.randomUUID().toString())
                .type(FileEventType.COMPLETE.name())
                .data(data)
                .build();
    }

    public static FileEvent toErrorEvent(Map<String, Object> data) {
        return FileEvent.builder()
                .id(UUID.randomUUID().toString())
                .type(FileEventType.ERROR.name())
                .data(data)
                .build();
    }
}