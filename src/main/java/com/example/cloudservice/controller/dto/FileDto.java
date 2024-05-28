package com.example.cloudservice.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileDto {
    String fileName;
    Long fileSize;
    byte[] fileContent;

//    TODO UserDto user;
}
