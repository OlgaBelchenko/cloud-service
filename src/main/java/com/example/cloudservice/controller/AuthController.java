package com.example.cloudservice.controller;

import com.example.cloudservice.dto.JwtResponse;
import com.example.cloudservice.dto.UserDto;
import com.example.cloudservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto user) {
        String token = authService.generateToken(user);
        return ResponseEntity.ok(new JwtResponse(token));
    }
}
