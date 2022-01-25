package com.memes.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserDtoResponse {

    private Long userId;
    private String username;
    private String email;
}
