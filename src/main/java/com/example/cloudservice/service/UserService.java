package com.example.cloudservice.service;

import com.example.cloudservice.data.UserDto;
import com.example.cloudservice.exception.ErrorInputData;
import com.example.cloudservice.repository.UserRepository;
import com.example.cloudservice.repository.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void login(UserDto user) {
        UserEntity userEntity = userRepository.getUserByUsername(user.getUsername());
        if (userEntity == null) {
            throw new ErrorInputData("Bad credentials");
        }
    }

    public void logout(String token) {
        // TODO UserController
    }
}
