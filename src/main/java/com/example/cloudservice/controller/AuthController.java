package com.example.cloudservice.controller;

import com.example.cloudservice.dto.JwtResponse;
import com.example.cloudservice.dto.UserDto;
import com.example.cloudservice.service.AuthService;
import com.example.cloudservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthController {
    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto user) {
        String token = authService.generateToken(user);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("auth-token") String token) {
        userService.logout(token);
        return ResponseEntity.ok("Success logout");
    }
}
