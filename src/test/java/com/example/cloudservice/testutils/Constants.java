package com.example.cloudservice.testutils;

import com.example.cloudservice.model.FileEntity;
import com.example.cloudservice.model.UserEntity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Constants {
    public static final String USERNAME = "testuser";
    public static final String PASSWORD = "testpass";
    public static UserEntity USER_ENTITY;

    public static FileEntity FILE_ENTITY;

    public static String TOKEN = "testtoken";

    static {
        USER_ENTITY = UserEntity.builder()
                .username(USERNAME)
                .password(PASSWORD)
                .build();
        try {
            final String pathToFile = "src/test/resources/test_file.txt";
            final Path path = Paths.get(pathToFile);
            FILE_ENTITY = FileEntity.builder()
                    .fileName(path.getFileName().toString())
                    .size(Files.size(path))
                    .content(Files.readAllBytes(path))
                    .user(USER_ENTITY)
                    .build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
