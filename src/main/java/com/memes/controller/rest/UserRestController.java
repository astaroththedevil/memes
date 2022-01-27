package com.memes.controller.rest;

import com.memes.model.dao.UserEntity;
import com.memes.model.dto.UserRequestDto;
import com.memes.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
    public UserEntity addNewUser(@RequestBody UserRequestDto request) {
        return userService.saveUser(request);
    }
}
