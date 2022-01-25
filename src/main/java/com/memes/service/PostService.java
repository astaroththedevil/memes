package com.memes.service;

import com.memes.exception.ApplicationError;
import com.memes.exception.ApplicationException;
import com.memes.model.dto.PostDtoResponse;
import com.memes.model.dto.converters.Converters;
import com.memes.repository.PostRepository;
import com.memes.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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


}
