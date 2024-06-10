package com.example.cloudservice.utils.mapper;

import com.example.cloudservice.dto.FileDto;
import com.example.cloudservice.model.FileEntity;

public class FileMapper {
    public static FileDto mapToFileDto(FileEntity file) {
        return new FileDto(file.getFileName(), file.getSize());
    }
}
