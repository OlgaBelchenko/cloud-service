package com.example.cloudservice.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "files")
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name", unique = true, nullable = false)
    private String fileName;

    @Column(name = "size")
    private Long size;

    @Column(name = "content", nullable = false)
    private byte[] content;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
