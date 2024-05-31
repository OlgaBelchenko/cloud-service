package com.example.cloudservice.controller;

import com.example.cloudservice.data.FileDto;
import com.example.cloudservice.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

        return new ResponseEntity<>("Success upload", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteFile(@RequestHeader("auth-token") String token,
                                        @RequestParam("filename") String fileName) {

        fileService.deleteFile(token, fileName);

        return new ResponseEntity<>("Success deleted", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> downloadFile(@RequestHeader("auth-token") String token,
                                          @RequestParam("filename") String fileName) {

        byte[] downloadedFile = fileService.downloadFile(token, fileName);

        return new ResponseEntity<>(downloadedFile, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> editFileName(@RequestHeader("auth-token") String token,
                                          @RequestParam("filename") String oldFileName,
                                          String newFileName) {

        fileService.editFileName(token, oldFileName, newFileName);

        return new ResponseEntity<>("Success upload", HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAllFiles(@RequestHeader("auth-token") String token,
                                         @RequestParam("limit") Integer limit) {

        List<FileDto> allFiles = fileService.getAllFiles(token, limit);
        return new ResponseEntity<>(allFiles, HttpStatus.OK);
    }
}
