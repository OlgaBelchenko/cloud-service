package com.example.cloudservice.repository;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static com.example.cloudservice.testutils.Constants.FILE_ENTITY;
import static com.example.cloudservice.testutils.Constants.USER_ENTITY;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FileRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FileRepository fileRepository;

    @BeforeAll
    void setUp() {
        userRepository.save(USER_ENTITY);
        fileRepository.save(FILE_ENTITY);
    }

    @AfterAll
    void tearDown() {
        fileRepository.delete(FILE_ENTITY);
        userRepository.delete(USER_ENTITY);
    }

    @Test
    void findByFileNameAndUser() {
        assertEquals(FILE_ENTITY, fileRepository.findByFileNameAndUser(FILE_ENTITY.getFileName(), USER_ENTITY).orElse(null));
    }

    @Test
    void findAllByUser() {
        assertEquals(List.of(FILE_ENTITY), fileRepository.findAllByUser(USER_ENTITY).orElse(null));
    }
}