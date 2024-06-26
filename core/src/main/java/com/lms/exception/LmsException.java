package com.lms.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Базовое исключение Lms.
 */
@Getter
public abstract class LmsException extends RuntimeException {

    private final HttpStatus httpStatus;

    protected LmsException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

    protected static String throwableToString(Throwable t) {
        return String.format("%s: %s%s",
                t.getClass().getSimpleName(),
                t.getMessage(),
                t.getCause() == null ? "" : ", cause: " + t.getCause());
    }
}