package com.example.cloudservice.exception;

public class ErrorInputData extends RuntimeException {
    public ErrorInputData(String message) {
        super(message);
    }
}
