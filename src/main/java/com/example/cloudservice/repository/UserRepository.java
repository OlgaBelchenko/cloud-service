package com.example.cloudservice.repository;

import com.example.cloudservice.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query("from UserEntity where username = :username")
    Optional<UserEntity> getUserByUsername(String username);
}
