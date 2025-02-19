package com.lms.core.model.dto.chapter;

import com.lms.core.model.dto.course.CourseDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChapterDto {
    private Long chapterId;
    private Long courseId;
//    private CourseDto course;
    private String title;
    private String description;
    private Integer position;
    private Boolean isPublished;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
