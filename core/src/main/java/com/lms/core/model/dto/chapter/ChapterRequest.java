package com.lms.core.model.dto.chapter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ChapterRequest(@NotBlank String title,
                             String description,
                             @NotNull Integer position,
                             @NotNull Boolean isPublished,
                             @NotNull Long courseId) {
}
