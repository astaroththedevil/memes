package com.memes.model.dto.converters;

import com.memes.model.dao.UserEntity;
import com.memes.model.dto.UserDtoRequest;
import org.springframework.stereotype.Component;

@Component
public class UserRequestConverter implements Converter<UserDtoRequest, UserEntity>{

    @Override
    public UserEntity convert(UserDtoRequest request) {
        UserEntity entity = new UserEntity();
        entity.setUsername(request.getUsername());
        entity.setPassword(request.getPassword());
        entity.setEmail(request.getEmail());
        return entity;
    }

    @Override
    public <T, R> boolean canHandle(Class<T> from, Class<R> to) {
        return from.equals(UserDtoRequest.class) && to.equals(UserEntity.class);
    }
}
