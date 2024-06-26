package com.lms.auth.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class LmsAuthException extends RuntimeException {
    private final HttpStatus httpStatus;

    protected LmsAuthException(HttpStatus httpStatus, String message) {
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
