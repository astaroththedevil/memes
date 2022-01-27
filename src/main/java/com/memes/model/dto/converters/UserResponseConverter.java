package com.memes.model.dto.converters;

import com.memes.model.dao.UserEntity;
import com.memes.model.dto.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserResponseConverter implements Converter<UserEntity, UserResponseDto>{

    @Override
    public UserResponseDto convert(UserEntity entity) {
        return UserResponseDto.builder()
                .userId(entity.getUserId())
                .username(entity.getUsername())
                .email(entity.getEmail())
                .build();
    }

    @Override
    public <T, R> boolean canHandle(Class<T> from, Class<R> to) {
        return from.equals(UserEntity.class) && to.equals(UserResponseDto.class);
    }
}
