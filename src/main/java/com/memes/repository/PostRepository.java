package com.memes.repository;

import com.memes.model.dao.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

    List<PostEntity> findAllByUserId(Long id);
    Optional<PostEntity> findByPostTitle(String title);
    Optional<PostEntity> findByPostIdAndPostOwner(Long id, String username);
}
