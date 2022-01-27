package com.memes.model.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequestDto {

    @Min(value = 0)
    private Long userId;

    @NotEmpty
    @Length(max = 30)
    private String title;

    @NotEmpty
    @Length(max = 200)
    private String description;

    @NotEmpty
    private String imgLink;
}
