package com.lms.core.model.dto.course;

public record CourseRequestPatch(String title,
                                 String description,
                                 String imageUrl,
                                 String price,
                                 String isPublished) {
}
