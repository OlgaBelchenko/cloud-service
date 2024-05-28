package com.example.cloudservice.controller;

import com.example.cloudservice.controller.dto.FileDto;
import com.example.cloudservice.service.CloudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class CloudController {
    private final CloudService cloudService;

    @PostMapping("/file")
    public ResponseEntity<?> uploadFile(@RequestHeader("auth-token") String token,
                                        @RequestParam("filename") String fileName,
                                        @RequestBody MultipartFile file) throws IOException {
        FileDto fileDto = new FileDto(fileName, file.getSize(), file.getBytes());
        cloudService.uploadFile(token, fileDto);
        return new ResponseEntity<>("Success upload", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteFile(@RequestHeader("auth-token") String token,
                                        @RequestParam("filename") String fileName,
                                        @RequestBody MultipartFile  file) {
        // TODO CloudController

        return null;
    }

    @GetMapping
    public byte[] downloadFile(@RequestHeader("auth-token") String token,
                                          @RequestParam("filename") String fileName,
                                          @RequestBody MultipartFile  file) {
        // TODO CloudController
        return null;
    }

    @PutMapping
    public ResponseEntity<?> editFileName(@RequestHeader("auth-token") String token,
                                          @RequestParam("filename") String oldFileName,
                                          String newFileName) {
        // TODO CloudController
        return null;
    }

    @GetMapping("/list")
    public List<FileDto> getAllFiles(@RequestHeader("auth-token") String token,
                                     @RequestParam("limit") Integer limit) {
        // TODO CloudController
        return null;
    }
}
