package com.lms.core.model.dto.course;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CourseDto {
    private Long courseId;
    private Long categoryId;
    private Long creatorId;
    private String name;
    private String description;
    private LocalDateTime created;
    private LocalDateTime updated;
}
