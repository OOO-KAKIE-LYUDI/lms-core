package com.lms.core.exception;

import lombok.Getter;

import static org.springframework.http.HttpStatus.GONE;

@Getter
public class LmsGoneException extends LmsException {

    private static final String DEFAULT_MESSAGE = "Истёк срок действия";

    public LmsGoneException(String message) {
        super(GONE, message);
    }

    public LmsGoneException(Throwable ex) {
        super(GONE, String.format("%s: %s", DEFAULT_MESSAGE, throwableToString(ex)));
    }

    public LmsGoneException(String message, Throwable ex) {
        super(GONE, String.format("%s: %s", message, throwableToString(ex)));
    }
}