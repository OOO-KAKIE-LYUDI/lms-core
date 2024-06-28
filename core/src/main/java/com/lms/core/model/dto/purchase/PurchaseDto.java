package com.lms.core.model.dto.purchase;

import com.lms.auth.model.dto.UserDto;
import com.lms.core.model.dto.course.CourseDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PurchaseDto {
    private Long purchaseId;
    private Long userId;
    private UserDto user;
    private Long courseId;
//    private CourseDto course;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
