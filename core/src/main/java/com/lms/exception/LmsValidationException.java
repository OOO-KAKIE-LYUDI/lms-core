package com.lms.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class LmsValidationException extends LmsException {

    private static final String DEFAULT_MESSAGE = "Ошибка валидации";

    public LmsValidationException(Throwable ex) {
        super(BAD_REQUEST, String.format("%s: %s", DEFAULT_MESSAGE, throwableToString(ex)));
    }

    public LmsValidationException(String message) {
        super(BAD_REQUEST, message);
    }
}