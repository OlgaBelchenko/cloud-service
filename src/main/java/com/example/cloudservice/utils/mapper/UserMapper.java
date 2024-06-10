package com.example.cloudservice.utils.mapper;

import com.example.cloudservice.dto.UserDto;
import com.example.cloudservice.model.UserEntity;

public class UserMapper {

    public static UserEntity mapToUserEntity(UserDto user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(user.getLogin());
        userEntity.setPassword(user.getPassword());
        return userEntity;
    }
}
