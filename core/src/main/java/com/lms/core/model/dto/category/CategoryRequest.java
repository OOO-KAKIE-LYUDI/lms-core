package com.lms.core.model.dto.category;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

public record CategoryRequest(@NotNull String name) {
}
