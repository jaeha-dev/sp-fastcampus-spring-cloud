package com.example.storage;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class FileController {
    private final FileService fileService;

    @GetMapping("/upload")
    public ResponseEntity<?> upload() {
        Map<String, Object> data = new HashMap<>();
        data.put("id", "001");
        data.put("type", "txt");
        data.put("size", "10");
        fileService.fileUpload(data);

        // return ResponseEntity.ok("성공");
        return new ResponseEntity<>("성공", HttpStatus.OK);
    }
}