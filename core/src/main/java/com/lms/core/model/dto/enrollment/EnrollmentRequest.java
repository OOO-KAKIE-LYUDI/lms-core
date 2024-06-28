package com.lms.core.model.dto.enrollment;

import lombok.Data;

@Data
public class EnrollmentRequest {
    private Long userId;
    private Long courseId;
}
