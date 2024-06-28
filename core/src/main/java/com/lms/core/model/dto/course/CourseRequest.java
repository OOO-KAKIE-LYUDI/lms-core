package com.lms.core.model.dto.course;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CourseRequest(@NotBlank String title,
                            String description,
                            String imageUrl,
                            String price,
                            String isPublished,
                            @NotNull Long categoryId,
                            @NotNull Long creatorId) {
}
