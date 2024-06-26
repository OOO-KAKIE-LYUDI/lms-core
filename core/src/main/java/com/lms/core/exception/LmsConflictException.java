package com.lms.core.exception;

import static org.springframework.http.HttpStatus.CONFLICT;

public class LmsConflictException extends LmsException {

    private static final String DEFAULT_MESSAGE = "Запрос не может быть выполнен из-за конфликтного обращения к ресурсу";

    public LmsConflictException(String message) {
        super(CONFLICT, message);
    }

    public LmsConflictException(Throwable ex) {
        super(CONFLICT, String.format("%s: %s", DEFAULT_MESSAGE, throwableToString(ex)));
    }

    public LmsConflictException(String message, Throwable ex) {
        super(CONFLICT, String.format("%s: %s", message, throwableToString(ex)));
    }
}