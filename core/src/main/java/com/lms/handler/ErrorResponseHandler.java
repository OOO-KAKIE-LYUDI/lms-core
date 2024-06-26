package com.lms.handler;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.lms.exception.LmsBadGatewayException;
import com.lms.exception.LmsConflictException;
import com.lms.exception.LmsException;
import com.lms.exception.LmsGoneException;
import com.lms.exception.LmsInternalException;
import com.lms.exception.LmsNotFoundException;
import com.lms.exception.LmsValidationException;
import com.lms.model.dto.response.Result;
import com.lms.model.dto.response.ServiceResponse;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestValueException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import static com.lms.model.dto.response.ResponseResultStatus.ERROR;
import static com.lms.model.dto.response.ResponseResultStatus.NOT_FOUND;

@ControllerAdvice
public class ErrorResponseHandler {

    @ExceptionHandler(value = Throwable.class)
    public ResponseEntity<ServiceResponse> handleException(Throwable ex) {

        LmsException e;
        String status = ERROR.getValue();

        if (ex instanceof LmsException) {
            e = (LmsException) ex;

            if (ex instanceof LmsNotFoundException) {
                status = NOT_FOUND.getValue();
            } else if (ex instanceof LmsGoneException ||
                    ex instanceof LmsConflictException ||
                    ex instanceof LmsBadGatewayException) {
                status = ERROR.getValue();
            }
        } else if (ex instanceof MethodArgumentNotValidException ||
                ex instanceof MethodArgumentTypeMismatchException ||
                ex instanceof MissingRequestValueException ||
                ex instanceof ValidationException ||
                ex.getCause() instanceof MismatchedInputException) {
            e = new LmsValidationException(ex);
        } else {
            e = new LmsInternalException(ex);
        }

        HttpStatus httpStatus = e.getHttpStatus();
        ServiceResponse response = ServiceResponse.builder()
                .result(Result.builder()
                        .code(httpStatus.value())
                        .status(status)
                        .message(e.getMessage())
                        .build())
                .build();

        return new ResponseEntity<>(response, httpStatus);
    }
}