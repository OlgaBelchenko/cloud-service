package com.example.cloudservice.exception;

public class ErrorUploadFile extends RuntimeException {
    public ErrorUploadFile(String message) {
        super(message);
    }
}
