package com.memes.model.dto.converters;

import com.memes.model.dao.PostEntity;
import com.memes.model.dto.PostDtoResponse;
import org.springframework.stereotype.Component;

@Component
public class PostResponseConverter implements Converter<PostEntity, PostDtoResponse> {

    @Override
    public PostDtoResponse convert(PostEntity entity) {
        return PostDtoResponse.builder()
                .postId(entity.getPostId())
                .build();
    }

    @Override
    public <T, R> boolean canHandle(Class<T> from, Class<R> to) {
        return from.equals(PostEntity.class) && to.equals(PostDtoResponse.class);
    }
}
