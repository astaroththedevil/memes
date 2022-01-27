package com.memes.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    @NotEmpty
    @Length(min = 6, max = 30)
    private String username;

    @NotEmpty
    @Length(min = 8, max = 100)
    private String password;

    @NotEmpty
    @Email
    private String email;
}
