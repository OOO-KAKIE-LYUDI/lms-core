package com.lms.core.model.dto.response;

import lombok.Builder;

@Builder
public record ServiceResponse (Result result, Object data) {
}
