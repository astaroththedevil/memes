package com.memes.service;

import com.memes.model.dao.UserEntity;
import com.memes.model.dto.UserDtoRequest;
import com.memes.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserEntity saveUser(UserDtoRequest request) {
        UserEntity user = new UserEntity();
        user.setUsername(request.getUsername());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        return repository.save(user);
    }

    public List<UserEntity> showAllUsers() {
        return repository.findAll();
    }
}
