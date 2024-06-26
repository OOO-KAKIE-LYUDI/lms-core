package com.lms.core.exception;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

public class LmsUnprocessableEntityException extends LmsException {

    private static final String DEFAULT_MESSAGE = "Неподдерживаемый контент";

    public LmsUnprocessableEntityException(String message) {
        super(UNPROCESSABLE_ENTITY, message);
    }

    public LmsUnprocessableEntityException(Throwable ex) {
        super(UNPROCESSABLE_ENTITY, String.format("%s: %s", DEFAULT_MESSAGE, throwableToString(ex)));
    }

    public LmsUnprocessableEntityException(String message, Throwable ex) {
        super(UNPROCESSABLE_ENTITY, String.format("%s: %s", message, throwableToString(ex)));
    }
}
