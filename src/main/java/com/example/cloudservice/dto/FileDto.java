package com.example.cloudservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileDto {
    String fileName;
    Long fileSize;
    byte[] fileContent;
}
