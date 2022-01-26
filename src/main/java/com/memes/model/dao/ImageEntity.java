package com.memes.model.dao;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "images")
public class ImageEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @NotNull
    @Column(name = "name")
    private String name;

    @NotEmpty
    @NotNull
    @Column(name = "type")
    private String type;

    @NotEmpty
    @NotNull
    @Lob
    @Column(name = "picByte", length = 20971520)
    private byte[] picByte;
}
