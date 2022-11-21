package com.example.jpatest.repository;

import com.example.jpatest.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository {
    UserEntity save(UserEntity user);
    void delete(Long id);

    void update(UserEntity user);
    Optional<UserEntity> findById(Long id);
    Optional<UserEntity> findByName(String name);
    List<UserEntity> findAll();
}
