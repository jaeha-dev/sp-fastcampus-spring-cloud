package com.example.demo.config;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import javax.annotation.PostConstruct;

@Slf4j
@Getter
@Setter
@Configuration
public class PhotoAppProperties {

    @Value("${app.file.default-path}")
    private String defaultPath;

    @PostConstruct
    private void init() {
        LOG.info("File Path: {}", defaultPath);
    }
}