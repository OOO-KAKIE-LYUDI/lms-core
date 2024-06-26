package com.lms.core.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class LmsBadRequestException extends LmsException {

    private static final String DEFAULT_MESSAGE = "Неверный запрос";

    public LmsBadRequestException(String message) {
        super(BAD_REQUEST, message);
    }

    public LmsBadRequestException(Throwable ex) {
        super(BAD_REQUEST, String.format("%s: %s", DEFAULT_MESSAGE, throwableToString(ex)));
    }

    public LmsBadRequestException(String message, Throwable ex) {
        super(BAD_REQUEST, String.format("%s: %s", message, throwableToString(ex)));
    }
}