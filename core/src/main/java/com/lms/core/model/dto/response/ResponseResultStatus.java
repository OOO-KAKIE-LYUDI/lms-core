package com.lms.core.model.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@RequiredArgsConstructor(access = PRIVATE)
public enum ResponseResultStatus {

    SUCCESS("success"),
    NOT_FOUND("not found"),
    ERROR("error");

    @Getter
    private final String value;
}
