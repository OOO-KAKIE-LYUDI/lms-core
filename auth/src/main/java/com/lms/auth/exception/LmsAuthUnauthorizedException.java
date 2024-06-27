package com.lms.auth.exception;

import lombok.Getter;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Getter
public class LmsAuthUnauthorizedException extends LmsAuthException {

    private static final String DEFAULT_MESSAGE = "Ошибка во время авторизации";

    public LmsAuthUnauthorizedException(String message) {
        super(UNAUTHORIZED, message);
    }

    public LmsAuthUnauthorizedException(Throwable ex) {
        super(UNAUTHORIZED, String.format("%s: %s", DEFAULT_MESSAGE, throwableToString(ex)));
    }

    public LmsAuthUnauthorizedException(String message, Throwable ex) {
        super(UNAUTHORIZED, String.format("%s: %s", message, throwableToString(ex)));
    }
}