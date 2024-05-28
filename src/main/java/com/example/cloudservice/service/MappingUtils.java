package com.example.cloudservice.service;

import com.example.cloudservice.controller.dto.FileDto;
import com.example.cloudservice.repository.entity.FileEntity;
import org.springframework.stereotype.Service;

@Service
public class MappingUtils {

    public FileDto mapToFileDto(FileEntity file) {
        return new FileDto(file.getFileName(), file.getSize(), file.getContent());
    }

    public FileEntity mapToFileEntity(FileDto fileDto) {
        FileEntity fileEntity = new FileEntity();
        fileEntity.setFileName(fileDto.getFileName());
        fileEntity.setContent(fileDto.getFileContent());
        fileEntity.setSize(fileDto.getFileSize());
//        TODO fileEntity.setUser(fileDto.getUser());
        return fileEntity;
    }
}