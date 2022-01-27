package com.memes.model.dto.converters;

import com.memes.model.dao.PostEntity;
import com.memes.model.dto.PostRequestDto;
import org.springframework.stereotype.Component;

@Component
public class PostRequestConverter implements Converter<PostRequestDto, PostEntity>{

    @Override
    public PostEntity convert(PostRequestDto request) {
        PostEntity entity = new PostEntity();
        entity.setPostTitle(request.getTitle());
        entity.setPostDescription(request.getDescription());
        entity.setImgLink(request.getImgLink());
        return entity;
    }

    @Override
    public <T,R> boolean canHandle(Class<T> from, Class<R> to) {
        return from.equals(PostRequestDto.class) && to.equals(PostEntity.class);
    }
}
