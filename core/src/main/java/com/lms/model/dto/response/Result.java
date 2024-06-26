package com.lms.model.dto.response;

import lombok.Builder;

@Builder
public record Result(Integer code,
                     String status,
                     String message) {
}
