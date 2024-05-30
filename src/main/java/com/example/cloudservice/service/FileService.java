package com.example.cloudservice.service;

import com.example.cloudservice.data.FileDto;
import com.example.cloudservice.exception.ErrorGettingFileList;
import com.example.cloudservice.exception.ErrorInputData;
import com.example.cloudservice.exception.ErrorUploadFile;
import com.example.cloudservice.repository.FileRepository;
import com.example.cloudservice.repository.entity.FileEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@Service
public class FileService {

    private final static String ERROR_INPUT_DATA = "Error input data";
    private final static String ERROR_UNAUTHORIZED = "Unauthorized error";
    private final static String ERROR_DELETE_FILE = "Error delete file";
    private final static String ERROR_UPLOAD_FILE = "Error upload file";
    private final static String ERROR_FILE_LIST = "Error getting file list";
    private final FileRepository fileRepository;

    public void uploadFile(String token, String fileName, MultipartFile file) {
        try {
            fileRepository.save(mapToFileEntity(fileName, file));
        } catch (IOException e) {
            throw new ErrorInputData(ERROR_INPUT_DATA);
        }
    }

    public void deleteFile(String token, String fileName) {
        // TODO error
        fileRepository.deleteFile(fileName);
    }

    public byte[] downloadFile(String token, String fileName) {
        byte[] file = fileRepository.downloadFile(fileName);
        if (file == null || file.length == 0) {
            throw new ErrorUploadFile(ERROR_UPLOAD_FILE);
        }
        return file;
    }

    public void editFileName(String token, String oldFileName, String newFileName) {
        // TODO error
        fileRepository.editFileName(oldFileName, newFileName);
    }

    public List<FileDto> getAllFiles(String token, Integer limit) {
        List<FileEntity> fileEntities = fileRepository.getAllFiles(limit);
        if (fileEntities == null) {
            throw new ErrorGettingFileList(ERROR_FILE_LIST);
        }
        return fileEntities.stream().map(this::mapToFileDto).toList();
    }

    private FileEntity mapToFileEntity(String fileName, MultipartFile file) throws IOException {
        FileEntity fileEntity = new FileEntity();
        fileEntity.setFileName(fileName);
        fileEntity.setContent(file.getBytes());
        fileEntity.setSize(file.getSize());
//        TODO fileEntity.setUser(fileDto.getUser());
        return fileEntity;
    }

    private FileDto mapToFileDto(FileEntity file) {
        return new FileDto(file.getFileName(), file.getSize(), file.getContent());
    }
}
