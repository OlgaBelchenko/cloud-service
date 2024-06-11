package com.example.cloudservice.service;

import com.example.cloudservice.config.CustomUserDetails;
import com.example.cloudservice.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

import static com.example.cloudservice.testutils.Constants.USERNAME;
import static com.example.cloudservice.testutils.Constants.USER_ENTITY;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        Mockito.when(userRepository.findUserByUsername(USERNAME)).thenReturn(Optional.ofNullable(USER_ENTITY));
    }

    @Test
    void loadUserByUsername() {
        UserDetails userDetails = new CustomUserDetails(USER_ENTITY);
        assertEquals(userDetails, userService.loadUserByUsername(USERNAME));
    }

    @Test
    void getUserFromDatabaseByUsername() {
        assertEquals(USER_ENTITY, userService.getUserFromDatabaseByUsername(USERNAME));
    }
}