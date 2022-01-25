package com.memes.repository;

import com.memes.model.dao.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUserName(String name);
    Optional<UserEntity> findByEmail(String email);
}
