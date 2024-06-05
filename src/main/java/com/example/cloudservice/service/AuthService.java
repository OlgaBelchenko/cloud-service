package com.example.cloudservice.service;

import com.example.cloudservice.dto.UserDto;
import com.example.cloudservice.exception.ErrorBadCredentials;
import com.example.cloudservice.token.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenManager jwtTokenManager;
    private final UserDetailsService userDetailsService;

    public String generateToken(UserDto user) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        } catch (BadCredentialsException e) {
            throw new ErrorBadCredentials("Bad credentials");
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        return jwtTokenManager.generateJwtToken(userDetails);
    }
}
