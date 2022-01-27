package com.memes.model.dto.converters;

import com.memes.model.dao.PostEntity;
import com.memes.model.dto.PostResponseDto;
import org.springframework.stereotype.Component;

@Component
public class PostResponseConverter implements Converter<PostEntity, PostResponseDto> {

    @Override
    public PostResponseDto convert(PostEntity entity) {
        return PostResponseDto.builder()
                .postId(entity.getPostId())
                .build();
    }

    @Override
    public <T, R> boolean canHandle(Class<T> from, Class<R> to) {
        return from.equals(PostEntity.class) && to.equals(PostResponseDto.class);
    }
}
