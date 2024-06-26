package com.lms.core.exception;

import lombok.Getter;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * Внутреннее исключение сервиса Lms.
 */
@Getter
public class LmsInternalException extends LmsException {

    private static final String DEFAULT_MESSAGE = "Внутренняя ошибка сервиса";

    public LmsInternalException(Throwable ex) {
        super(INTERNAL_SERVER_ERROR, String.format("%s: %s", DEFAULT_MESSAGE, throwableToString(ex)));
    }

    public LmsInternalException(String message) {
        super(INTERNAL_SERVER_ERROR, message);
    }

    public LmsInternalException(String message, Throwable ex) {
        super(INTERNAL_SERVER_ERROR, String.format("%s: %s", message, throwableToString(ex)));
    }
}