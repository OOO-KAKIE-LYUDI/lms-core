package com.lms.auth.exception;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public class LmsAuthNotFoundException extends LmsAuthException {

    private static final String DEFAULT_MESSAGE = "Не найдено";

    public LmsAuthNotFoundException(Throwable ex) {
        super(NOT_FOUND, String.format("%s: %s", DEFAULT_MESSAGE, throwableToString(ex)));
    }

    public LmsAuthNotFoundException(String message) {
        super(NOT_FOUND, message);
    }

    public LmsAuthNotFoundException(String message, Throwable ex) {
        super(NOT_FOUND, String.format("%s: %s", message, throwableToString(ex)));
    }
}