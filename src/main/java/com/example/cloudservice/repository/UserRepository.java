package com.example.cloudservice.repository;

import com.example.cloudservice.repository.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Transactional
    @Query("from UserEntity where username = :username")
    UserEntity getUserByUsername(String username);
}
