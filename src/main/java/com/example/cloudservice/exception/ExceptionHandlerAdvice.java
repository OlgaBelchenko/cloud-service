package com.example.cloudservice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(ErrorGettingFileList.class)
    public ResponseEntity<String> errorFileListHandler(ErrorGettingFileList e) {
        return new ResponseEntity<>(e.getMessage(), INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ErrorUploadFile.class)
    public ResponseEntity<String> errorUploadHandler(ErrorUploadFile e) {
        return new ResponseEntity<>(e.getMessage(), INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ErrorInputData.class)
    public ResponseEntity<String> inputDataHandler(ErrorInputData e) {
        return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedError.class)
    public ResponseEntity<String> unauthorizedErrorHandler(UnauthorizedError e) {
        return new ResponseEntity<>(e.getMessage(), UNAUTHORIZED);
    }
}
