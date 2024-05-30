package com.example.cloudservice.repository;

import com.example.cloudservice.repository.entity.FileEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Long> {

    @Transactional
    @Query("delete from FileEntity where fileName = :fileName")
    void deleteFile(String fileName);

    @Transactional
    @Query("select content from FileEntity where fileName = :fileName")
    byte[] downloadFile(String fileName);

    @Query("update FileEntity set fileName = :newFileName where fileName = :oldFileName")
    void editFileName(String oldFileName, String newFileName);

    @Query("from FileEntity order by fileName limit :limit")
    List<FileEntity> getAllFiles(Integer limit);
}
