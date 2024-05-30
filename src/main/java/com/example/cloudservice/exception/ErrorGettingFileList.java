package com.example.cloudservice.exception;

public class ErrorGettingFileList extends RuntimeException {
    public ErrorGettingFileList(String message) {
        super(message);
    }
}
