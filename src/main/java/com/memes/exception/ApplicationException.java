package com.memes.exception;

import java.time.LocalDateTime;

public class ApplicationException extends RuntimeException{

    private final LocalDateTime exceptionTime;
    private final int errorStatus;
    private final String internalErrorCode;

    public ApplicationException(ApplicationError error, Object ... messageParameters) {

        super(String.format(error.getMessageTemplate(), messageParameters));
        this.exceptionTime = LocalDateTime.now();
        this.errorStatus = error.getHttpStatus();
        this.internalErrorCode = error.getInternalErrorCode();
    }
}
