package com.example.cloudservice.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthToken {
    @JsonProperty("auth-token")
    String authToken;
}
