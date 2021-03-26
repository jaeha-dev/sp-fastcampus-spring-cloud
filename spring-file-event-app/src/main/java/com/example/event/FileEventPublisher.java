package com.example.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FileEventPublisher {
    private final ApplicationEventPublisher publisher;

    public void notifyFileEventComplete(FileEvent fileEvent) {
        publisher.publishEvent(fileEvent);
    }

    public void notifyFileEventError(FileEvent fileEvent) {
        publisher.publishEvent(fileEvent);
    }
}