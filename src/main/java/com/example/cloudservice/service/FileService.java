package com.example.cloudservice.service;

import com.example.cloudservice.dto.FileDto;
import com.example.cloudservice.exception.ErrorGettingFileList;
import com.example.cloudservice.exception.ErrorUploadFile;
import com.example.cloudservice.exception.UnauthorizedError;
import com.example.cloudservice.repository.FileRepository;
import com.example.cloudservice.repository.UserRepository;
import com.example.cloudservice.repository.entity.FileEntity;
import com.example.cloudservice.repository.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FileService {

    private final static String ERROR_INPUT_DATA = "Error input data";
    private final static String ERROR_UNAUTHORIZED = "Unauthorized error";
    private final static String ERROR_DELETE_FILE = "Error delete file";
    private final static String ERROR_UPLOAD_FILE = "Error upload file";
    private final static String ERROR_FILE_LIST = "Error getting file list";
    private final FileRepository fileRepository;
    private final UserRepository userRepository;

    public void uploadFile(String username, String fileName, MultipartFile file) throws IOException {
        UserEntity userEntity = getUserEntity(username);
        FileEntity fileEntity = new FileEntity();
        fileEntity.setFileName(fileName);
        fileEntity.setSize(file.getSize());
        fileEntity.setContent(file.getBytes());
        fileEntity.setUser(userEntity);
        fileRepository.save(fileEntity);
    }

    public void deleteFile(String username, String fileName) {
        fileRepository.delete(getFileEntityByUserFileName(username, fileName));
    }

    public byte[] downloadFile(String username, String fileName) {
        FileEntity fileEntity = getFileEntityByUserFileName(username, fileName);
        if (fileEntity == null) {
            throw new ErrorUploadFile(ERROR_UPLOAD_FILE);
        }
        return fileEntity.getContent();
    }

    public void editFileName(String username, String oldFileName, String newFileName) {
        FileEntity fileEntity = getFileEntityByUserFileName(username, oldFileName);
        fileEntity.setFileName(newFileName);
        fileRepository.save(fileEntity);
    }

    public List<FileDto> getAllFiles(String username, int limit) {
        UserEntity userEntity = getUserEntity(username);
        List<FileEntity> fileEntities = fileRepository.findAllByUser(userEntity).orElse(new ArrayList<>());
        return fileEntities.stream().limit(limit).map(this::mapToFileDto).toList();
    }

    private FileEntity getFileEntityByUserFileName(String username, String fileName) {
        UserEntity user = getUserEntity(username);
        return fileRepository.findByFileNameAndUser(fileName, user)
                .orElseThrow(() -> new ErrorGettingFileList(ERROR_FILE_LIST));
    }

    private UserEntity getUserEntity(String username) {
        return userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UnauthorizedError(ERROR_UNAUTHORIZED));
    }

    private FileDto mapToFileDto(FileEntity file) {
        return new FileDto(file.getFileName(), file.getSize());
    }
}
