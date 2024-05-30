package com.example.cloudservice.controller;

import com.example.cloudservice.data.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

public class UserController {
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto user) {
        // TODO UserController
        return null;
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("auth-token") String token) {
        // TODO UserController
        return null;
    }
}
