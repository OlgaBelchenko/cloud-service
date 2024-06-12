package com.example.cloudservice.testutils;

import com.example.cloudservice.model.FileEntity;
import com.example.cloudservice.model.UserEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import org.testcontainers.containers.Network;

import java.io.IOException;

public class TestUtils {
    public static final String USERNAME = "testuser";
    public static final String PASSWORD = "testpass";
    public static UserEntity USER_ENTITY;

    public static FileEntity FILE_ENTITY;

    public static String TOKEN = "testtoken";

    public static MultipartFile MULTIPART_FILE;

    public static final int DB_PORT = 5432;
    public static final String DB_NAME = "cloud_db";
    public static final String DB_USERNAME = "postgres";
    public static final String DB_PASSWORD = "postgres";
    public static final Network NETWORK = Network.newNetwork();

    static {
        USER_ENTITY = UserEntity.builder()
                .username(USERNAME)
                .password(PASSWORD)
                .build();


        MULTIPART_FILE = new MockMultipartFile(
                "test.txt",
                "test".getBytes()
        );
        try {
            FILE_ENTITY = FileEntity.builder()
                    .fileName(MULTIPART_FILE.getName())
                    .size(MULTIPART_FILE.getSize())
                    .content(MULTIPART_FILE.getBytes())
                    .user(USER_ENTITY)
                    .build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
