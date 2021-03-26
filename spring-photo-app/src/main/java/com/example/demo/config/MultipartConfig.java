package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Configuration
public class MultipartConfig {

    @Value("${app.file.default-path}")
    public String defaultPath;

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setResolveLazily(true);
        multipartResolver.setMaxUploadSize(1024 * 1024 * 10);
        multipartResolver.setDefaultEncoding(StandardCharsets.UTF_8.displayName());

        try {
            LOG.info("File Path: " + defaultPath);
            multipartResolver.setUploadTempDir(new FileSystemResource(defaultPath));
        } catch (IOException e) {
            LOG.error("IO Error: ", e);
        }

        return multipartResolver;
    }
}
