package com.lms.core.exception;

import static org.springframework.http.HttpStatus.BAD_GATEWAY;

public class LmsBadGatewayException extends LmsException {

    private static final String DEFAULT_MESSAGE = "Вышестоящий сервис недоступен";

    public LmsBadGatewayException(String message) {
        super(BAD_GATEWAY, message);
    }

    public LmsBadGatewayException(Throwable ex) {
        super(BAD_GATEWAY, String.format("%s: %s", DEFAULT_MESSAGE, throwableToString(ex)));
    }

    public LmsBadGatewayException(String message, Throwable ex) {
        super(BAD_GATEWAY, String.format("%s: %s", message, throwableToString(ex)));
    }
}