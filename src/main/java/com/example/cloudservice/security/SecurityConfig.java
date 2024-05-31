package com.example.cloudservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig implements WebMvcConfigurer {
//    @Bean
//    public UserDetailsService userDetailsService(BCryptPasswordEncoder passwordEncoder) {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("user")
//                .password(passwordEncoder.encode("123"))
//                .roles("READ").build());
//        manager.createUser(User.withUsername("writer")
//                .password(passwordEncoder.encode("12345"))
//                .roles("READ", "WRITE").build());
//        manager.createUser(User.withUsername("admin")
//                .password(passwordEncoder.encode("password"))
//                .roles("READ", "WRITE", "DELETE").build());
//        return manager;
//    }
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedOrigins("http://localhost:8081") // TODO front address
                .allowedMethods("*");
    }
}
