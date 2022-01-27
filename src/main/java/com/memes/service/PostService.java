package com.memes.service;

import com.memes.exception.ApplicationError;
import com.memes.exception.ApplicationException;
import com.memes.model.dao.PostEntity;
import com.memes.model.dao.UserEntity;
import com.memes.model.dto.PostDtoRequest;
import com.memes.model.dto.PostDtoResponse;
import com.memes.model.dto.converters.Converters;
import com.memes.repository.PostRepository;
import com.memes.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final Converters converters;

    public List<PostDtoResponse> getAllPosts() {
        return postRepository.findAll().stream().map(request -> converters.convert(request, PostDtoResponse.class)).collect(Collectors.toList());
    }

    public PostDtoResponse getById(Long id) {
        return postRepository.findById(id)
                .map(post -> converters.convert(post, PostDtoResponse.class))
                .orElseThrow(() -> new ApplicationException(ApplicationError.POST_DOESNT_EXIST, id));
    }

    public List<PostDtoResponse> getByUserId(Long userId) {
        return postRepository.findAllByUserId(userId)
                .stream()
                .map(post -> converters.convert(post, PostDtoResponse.class))
                .collect(Collectors.toList());
    }

    public PostDtoResponse getByTitle(String title) {
        return postRepository.findByTitle(title)
                .map(post -> converters.convert(post, PostDtoResponse.class))
                .orElseThrow(() -> new ApplicationException(ApplicationError.POST_DOESNT_EXIST, title));
    }

    @Transactional
    public PostDtoResponse savePost(PostDtoRequest request) {
        PostEntity entity = converters.convert(request, PostEntity.class);
        PostEntity savedEntity = postRepository.save(entity);

        String name = getCurrentUsername();
        UserEntity userEntity = userRepository.findByUserName(name).orElseThrow();

        //double sided binding

        ArrayList<PostEntity> postEntities = Objects.isNull(userEntity.getPosts()) ? new ArrayList<>() : new ArrayList<>(userEntity.getPosts());
        postEntities.add(savedEntity);
        userEntity.setPosts(postEntities);

        savedEntity.setPostOwner(userEntity);
        return converters.convert(savedEntity, PostDtoResponse.class);

    }

    private String getCurrentUsername() {
        String name = Optional.ofNullable(SecurityContextHolder.getContext())
                .map(user -> user.getAuthentication())
                .map(user -> user.getName()).orElseThrow();
        return name;
    }

    @Transactional
    public PostDtoResponse updateById(PostEntity request, Long id, String username) {
        PostEntity post =  postRepository.findByIdAndOwnerUserName(id, username).orElseThrow();
        updateByRequestData(request, id, post);
        PostEntity updatedPost = postRepository.save(post);
        return converters.convert(updatedPost, PostDtoResponse.class);
    }

    private void updateByRequestData(PostEntity request, Long id, PostEntity post) {
        post.setPostId(id);
        post.setPostTitle(request.getPostTitle());
        post.setPostDescription(request.getPostDescription());
        post.setPostOwner(request.getPostOwner());
        post.setImgLink(request.getImgLink());
        post.setDateOfCreation(LocalDateTime.now());
    }

    public PostDtoResponse deletePost(Long id, String username) {
        PostEntity entity = postRepository.findByIdAndOwnerUserName(id, username).orElseThrow(() -> new ApplicationException(ApplicationError.POST_DOESNT_EXIST));
        postRepository.deleteById(id);
        return converters.convert(entity, PostDtoResponse.class);
    }
}
