package com.example.cloudservice.controller;

import com.example.cloudservice.data.AuthToken;
import com.example.cloudservice.data.UserDto;
import com.example.cloudservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto user) {
        AuthToken authToken = userService.login(user);
        return new ResponseEntity<>(authToken, HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("auth-token") String token) {
        userService.logout(token);
        return new ResponseEntity<>("Success logout", HttpStatus.OK);
    }
}
