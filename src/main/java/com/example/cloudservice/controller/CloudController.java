package com.example.cloudservice.controller;

import com.example.cloudservice.something.File;
import com.example.cloudservice.something.Login;
import com.example.cloudservice.something.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
public interface CloudController {
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user);

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("auth-token") String token);


    @PostMapping("/file")
    public ResponseEntity<?> uploadFile(@RequestHeader("auth-token") String token,
                                        @RequestParam("filename") String fileName,
                                        @RequestBody MultipartFile file);

    @DeleteMapping
    public ResponseEntity<?> deleteFile(@RequestHeader("auth-token") String token,
                                        @RequestParam("filename") String fileName,
                                        @RequestBody File file);

    @GetMapping
    public ResponseEntity<?> downloadFile(@RequestHeader("auth-token") String token,
                                          @RequestParam("filename") String fileName,
                                          @RequestBody File file);

    @PutMapping
    public ResponseEntity<?> editFileName(@RequestHeader("auth-token") String token,
                                          @RequestParam("filename") String oldFileName,
                                          String newFileName);

    @GetMapping("/list")
    public ResponseEntity<?> getAllFiles(@RequestHeader("auth-token") String token,
                                         @RequestParam("limit") Integer limit);
}
