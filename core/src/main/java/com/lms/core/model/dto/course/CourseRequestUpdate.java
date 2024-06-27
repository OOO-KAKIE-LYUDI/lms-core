package com.lms.core.model.dto.course;

public record CourseRequestUpdate(String name,
                                 String description,
                                 Long categoryId,
                                 Long creatorId) {
}
