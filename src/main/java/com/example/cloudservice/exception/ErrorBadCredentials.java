package com.example.cloudservice.exception;

public class ErrorBadCredentials extends RuntimeException {
    public ErrorBadCredentials(String message) {
        super(message);
    }
}
