package com.lms.core.model.dto.course;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CourseRequest(@NotBlank String name,
                            String description,
                            @NotNull Long categoryId,
                            @NotNull Long creatorId) {
}
