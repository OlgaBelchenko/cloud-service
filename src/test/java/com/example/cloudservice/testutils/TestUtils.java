package com.example.cloudservice.testutils;

import com.example.cloudservice.dto.UserDto;
import com.example.cloudservice.model.FileEntity;
import com.example.cloudservice.model.UserEntity;
import lombok.SneakyThrows;

public class TestUtils {

    public static UserEntity USER_ENTITY;
    public static UserDto USER_DTO;
    public static FileEntity FILE_ENTITY;
    public static final UserEntity USER_ENTITY_REPO;

    static {
        USER_ENTITY_REPO = initUserEntity("test", "test");
        USER_ENTITY = initUserEntity("user", "$2a$12$vNiU/keMwu0NzZ97qho0VOGMWukcqZL1PioUi8uGyNR1vxqSLUVxC");
        USER_DTO = initUserDto();
        FILE_ENTITY = initFileEntity();
    }

    @SneakyThrows
    private static FileEntity initFileEntity() {
        return FileEntity.builder()
                .fileName("test.txt")
                .size(4L)
                .content("test".getBytes())
                .user(USER_ENTITY)
                .build();
    }

    private static UserDto initUserDto() {
        return UserDto.builder()
                .login("user")
                .password("user")
                .build();
    }

    private static UserEntity initUserEntity(String username, String password) {
        return UserEntity.builder()
                .username(username)
                .password(password)
                .build();
    }
}
