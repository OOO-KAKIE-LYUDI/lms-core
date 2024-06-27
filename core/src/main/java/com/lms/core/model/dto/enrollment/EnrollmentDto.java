package com.lms.core.model.dto.enrollment;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EnrollmentDto {

    private Long enrollmentId;
    private Long userId;
    private Long courseId;
    private LocalDateTime created;
    private LocalDateTime updated;
}