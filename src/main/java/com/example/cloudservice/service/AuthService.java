package com.example.cloudservice.service;

import com.example.cloudservice.controller.dto.UserDto;
import com.example.cloudservice.exception.ErrorBadCredentials;
import com.example.cloudservice.token.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import static com.example.cloudservice.exception.ErrorMessage.ERROR_BAD_CREDENTIALS;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenManager jwtTokenManager;
    private final UserDetailsService userDetailsService;

    public String generateToken(UserDto user) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword()));
        } catch (BadCredentialsException e) {
            log.error("Bad credentials for username: {}", user.getLogin());
            throw new ErrorBadCredentials(ERROR_BAD_CREDENTIALS.toString());
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getLogin());
        return jwtTokenManager.generateJwtToken(userDetails);
    }
}
