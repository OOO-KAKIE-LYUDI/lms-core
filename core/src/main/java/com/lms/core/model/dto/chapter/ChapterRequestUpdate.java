package com.lms.core.model.dto.chapter;

public record ChapterRequestUpdate(String title,
                                   String description,
                                   Integer position,
                                   Boolean isPublished,
                                   Long courseId) {
}
