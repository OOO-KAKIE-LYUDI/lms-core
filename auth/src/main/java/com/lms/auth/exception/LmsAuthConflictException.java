package com.lms.auth.exception;

import lombok.Getter;

import static org.springframework.http.HttpStatus.CONFLICT;


@Getter
public class LmsAuthConflictException extends LmsAuthException {

    private static final String DEFAULT_MESSAGE = "Запрос не может быть выполнен из-за конфликтного обращения к ресурсу";

    public LmsAuthConflictException(String message) {
        super(CONFLICT, message);
    }

    public LmsAuthConflictException(Throwable ex) {
        super(CONFLICT, String.format("%s: %s", DEFAULT_MESSAGE, throwableToString(ex)));
    }

    public LmsAuthConflictException(String message, Throwable ex) {
        super(CONFLICT, String.format("%s: %s", message, throwableToString(ex)));
    }
}
