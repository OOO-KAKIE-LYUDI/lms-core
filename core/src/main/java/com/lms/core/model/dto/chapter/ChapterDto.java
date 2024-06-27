package com.lms.core.model.dto.chapter;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChapterDto {
    private Long chapterId;
    private Long courseId;
    private String title;
    private String description;
    private Integer position;
    private Boolean isPublished;
    private LocalDateTime created;
    private LocalDateTime updated;
}
