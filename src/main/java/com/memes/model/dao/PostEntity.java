package com.memes.model.dao;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "posts")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;

    @Column(name = "post_Title")
    @NotEmpty
    @NotNull
    @Size(min = 6, max = 30, message = "Title must be at least 6 and at most 30 characters long")
    private String postTitle;

    @Column(name = "post_description")
    @NotEmpty
    @NotNull
    @Size(min = 6, max = 200, message = "Description must be at least 6 and at most 200 characters long")
    private String postDescription;

    @Column(name = "date_of_creation")
    @NotEmpty
    @NotNull
    private LocalDateTime dateOfCreation;

    @Column(name = "image_link")
    @NotEmpty
    @NotNull
    private String imgLink;

    @ManyToOne
    private UserEntity postOwner;
}
