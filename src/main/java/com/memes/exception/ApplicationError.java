package com.memes.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ApplicationError {

    POST_DOESNT_EXIST(
            "Post with presented id (%s) doesn't exist",
            400,
            "PDE-001"
    ),
    CONVERTER_NOT_FOUND(
            "Contact with administrators for more information",
            500,
            "CONV-001"
    );

    private final String messageTemplate;
    private final int httpStatus;
    private final String internalErrorCode;
}
