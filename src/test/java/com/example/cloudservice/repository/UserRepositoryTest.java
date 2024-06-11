package com.example.cloudservice.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static com.example.cloudservice.testutils.Constants.USER_ENTITY;
import static com.example.cloudservice.testutils.Constants.USERNAME;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository.save(USER_ENTITY);
    }

    @AfterEach
    void tearDown() {
        userRepository.delete(USER_ENTITY);
    }

    @Test
    void findUserByUsername() {
        assertEquals(USER_ENTITY, userRepository.findUserByUsername(USERNAME).orElse(null));
    }
}