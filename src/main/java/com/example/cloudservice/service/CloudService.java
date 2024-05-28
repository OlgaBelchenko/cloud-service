package com.example.cloudservice.service;

import com.example.cloudservice.controller.dto.FileDto;
import com.example.cloudservice.repository.CloudRepository;
import com.example.cloudservice.repository.entity.FileEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@AllArgsConstructor
@Service
public class CloudService {
    private final CloudRepository cloudRepository;
    private final MappingUtils mappingUtils;

    public void uploadFile(String token, FileDto fileDto) {
        FileEntity fileEntity = mappingUtils.mapToFileEntity(fileDto);
        cloudRepository.save(fileEntity);
    }

    public void deleteFile(@RequestHeader("auth-token") String token,
                           @RequestParam("filename") String fileName,
                           @RequestBody FileDto file) {
        // TODO CloudService
    }

    public byte[] downloadFile(String token, String fileName, FileDto file) {
        // TODO CloudService
        return null;
    }

    public void editFileName(String token, String oldFileName, String newFileName) {
        // TODO CloudService
    }

    public List<FileDto> getAllFiles(String token,
                                     Integer limit) {
        List<FileEntity> fileEntities = cloudRepository.getAllFiles(limit);
        return fileEntities.stream().map(mappingUtils::mapToFileDto).toList();
    }
}
