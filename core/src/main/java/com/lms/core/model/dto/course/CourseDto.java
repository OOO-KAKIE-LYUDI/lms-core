package com.lms.core.model.dto.course;

import com.lms.core.model.dto.category.CategoryDto;
import com.lms.core.model.dto.chapter.ChapterDto;
import com.lms.core.model.dto.purchase.PurchaseDto;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CourseDto {
    private Long courseId;
    private Long userId;
    private String title;
    private String description;
    private String imageUrl;
    private Double price;
    private Boolean isPublished;
    private Long categoryId;
    private CategoryDto category;
    private List<ChapterDto> chapters;
    private List<PurchaseDto> purchases;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
