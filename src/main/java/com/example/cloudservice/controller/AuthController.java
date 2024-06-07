package com.example.cloudservice.controller;

import com.example.cloudservice.dto.LoginResponse;
import com.example.cloudservice.dto.UserDto;
import com.example.cloudservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto user) {
        String token = authService.generateToken(user);
        log.info("Successfully logged in: {}", user.getLogin());
        return ResponseEntity.ok(new LoginResponse(token));
    }
}
