package com.memes.model.dao;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username")
    @NotEmpty
    @NotNull
    @Size(min = 6, max = 30, message = "Username must be at least 6 and at most 30 characters long.")
    private String username;

    @Column(name = "password")
    @NotEmpty
    @NotNull
    @Size(min = 8, max = 100, message = "Password must be at least 6 and at most 30 characters long.")
    private String password;

    @Column(name = "email")
    @NotEmpty
    @NotNull
    @Email
    private String email;

    @OneToMany
    private List<PostEntity> posts;
}
