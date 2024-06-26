package com.lms.core.model.dto.category;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CategoryDto {
    private Long categoryId;
    private String name;
    private LocalDateTime created;
    private LocalDateTime updated;
}
