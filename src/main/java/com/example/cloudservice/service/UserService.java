package com.example.cloudservice.service;

import com.example.cloudservice.data.AuthToken;
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

    public AuthToken login(UserDto user) {
        UserEntity userEntity = userRepository.getUserByUsername(user.getUsername());
        if (userEntity == null) {
            throw new ErrorInputData("Bad credentials");
        }
        if (!userEntity.getPassword().equals(user.getPassword())) {
            throw new ErrorInputData("Bad credentials");
        }
        return generateToken();
    }

    private AuthToken generateToken() {
        // TODO UserService generate token
        return null;
    }

    public void logout(String token) {
        // TODO UserService deactivate token
    }


}
