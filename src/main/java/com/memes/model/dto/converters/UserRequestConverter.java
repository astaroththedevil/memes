package com.memes.model.dto.converters;

import com.memes.model.dao.UserEntity;
import com.memes.model.dto.UserRequestDto;
import org.springframework.stereotype.Component;

@Component
public class UserRequestConverter implements Converter<UserRequestDto, UserEntity>{

    @Override
    public UserEntity convert(UserRequestDto request) {
        UserEntity entity = new UserEntity();
        entity.setUsername(request.getUsername());
        entity.setPassword(request.getPassword());
        entity.setEmail(request.getEmail());
        return entity;
    }

    @Override
    public <T, R> boolean canHandle(Class<T> from, Class<R> to) {
        return from.equals(UserRequestDto.class) && to.equals(UserEntity.class);
    }
}
