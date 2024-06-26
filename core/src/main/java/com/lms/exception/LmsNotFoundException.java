package com.lms.exception;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public class LmsNotFoundException extends LmsException {

    private static final String DEFAULT_MESSAGE = "Не найдено";

    public LmsNotFoundException(Throwable ex) {
        super(NOT_FOUND, String.format("%s: %s", DEFAULT_MESSAGE, throwableToString(ex)));
    }

    public LmsNotFoundException(String message) {
        super(NOT_FOUND, message);
    }

    public LmsNotFoundException(String message, Throwable ex) {
        super(NOT_FOUND, String.format("%s: %s", message, throwableToString(ex)));
    }
}