package com.example.cloudservice.controller;

import com.example.cloudservice.dto.FileDto;
import com.example.cloudservice.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class FileController {
    private final FileService fileService;

    @PostMapping("/file")
    public ResponseEntity<?> uploadFile(Principal userPrincipal,
                                        @RequestParam("filename") String fileName,
                                        @RequestBody MultipartFile file) throws IOException {

        fileService.uploadFile(userPrincipal.getName(), fileName, file);

        return ResponseEntity.ok("Success upload");
    }

    @DeleteMapping
    public ResponseEntity<?> deleteFile(Principal userPrincipal,
                                        @RequestParam("filename") String fileName) {

        fileService.deleteFile(userPrincipal.getName(), fileName);

        return ResponseEntity.ok("Success deleted");
    }

    @GetMapping
    public ResponseEntity<?> downloadFile(Principal userPrincipal, @RequestParam("filename") String fileName) {

        byte[] downloadedFile = fileService.downloadFile(userPrincipal.getName(), fileName);

        return ResponseEntity.ok(downloadedFile);
    }

    @PutMapping
    public ResponseEntity<?> editFileName(Principal userPrincipal,
                                          @RequestParam("filename") String oldFileName,
                                          String newFileName) {

        fileService.editFileName(userPrincipal.getName(), oldFileName, newFileName);

        return ResponseEntity.ok("Success upload");
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAllFiles(Principal userPrincipal,
                                         @RequestParam("limit") Integer limit) {

        List<FileDto> allFiles = fileService.getAllFiles(limit);
        return ResponseEntity.ok(allFiles);
    }
}
