package com.example.cloudservice.service;

import com.example.cloudservice.repository.FileRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class FileServiceTest {

    @InjectMocks
    private FileService fileService;

    @Mock
    private FileRepository fileRepository;

    @Test
    void uploadFile() {
    }

    @Test
    void deleteFile() {
    }

    @Test
    void downloadFile() {
    }

    @Test
    void editFileName() {
    }

    @Test
    void getAllFiles() {
    }
}