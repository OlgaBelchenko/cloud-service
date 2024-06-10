package com.example.cloudservice.repository;

import com.example.cloudservice.model.FileEntity;
import com.example.cloudservice.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Long> {
    Optional<FileEntity> findByFileNameAndUser(String fileName, UserEntity user);

    Optional<List<FileEntity>> findAllByUser(UserEntity user);
}
