package com.example.cloudservice.controller;

import com.example.cloudservice.dto.FileDto;
import com.example.cloudservice.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class FileController {
    private final FileService fileService;

    @PostMapping("/file")
    public ResponseEntity<?> uploadFile(@RequestHeader("auth-token") String token,
                                        @RequestParam("filename") String fileName,
                                        @RequestBody MultipartFile file) {

        fileService.uploadFile(token, fileName, file);

        return ResponseEntity.ok("Success upload");
    }

    @DeleteMapping
    public ResponseEntity<?> deleteFile(@RequestHeader("auth-token") String token,
                                        @RequestParam("filename") String fileName) {

        fileService.deleteFile(token, fileName);

        return ResponseEntity.ok("Success deleted");
    }

    @GetMapping
    public ResponseEntity<?> downloadFile(@RequestHeader("auth-token") String token,
                                          @RequestParam("filename") String fileName) {

        byte[] downloadedFile = fileService.downloadFile(token, fileName);

        return ResponseEntity.ok(downloadedFile);
    }

    @PutMapping
    public ResponseEntity<?> editFileName(@RequestHeader("auth-token") String token,
                                          @RequestParam("filename") String oldFileName,
                                          String newFileName) {

        fileService.editFileName(token, oldFileName, newFileName);

        return ResponseEntity.ok("Success upload");
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAllFiles(@RequestHeader("auth-token") String token,
                                         @RequestParam("limit") Integer limit) {

        List<FileDto> allFiles = fileService.getAllFiles(token, limit);
        return ResponseEntity.ok(allFiles);
    }
}
