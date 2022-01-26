package com.memes.controller.rest;

import com.memes.model.dao.UserEntity;
import com.memes.model.dto.UserDtoRequest;
import com.memes.model.dto.UserDtoResponse;
import com.memes.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(path = "/rest")
public class UserRestController {

    private final UserService userService;

    @GetMapping(path = "/all-users")
    public List<UserEntity> getAllUsers() {
        return userService.showAllUsers();
    }

    @PostMapping(path = "/add-user")
    public UserEntity addNewUser(UserDtoRequest request) {
        return userService.saveUser(request);
    }
}
