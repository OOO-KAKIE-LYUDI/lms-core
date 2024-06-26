package com.lms.service;

import com.lms.model.dto.category.CategoryDto;
import com.lms.model.dto.category.CategoryRequest;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> findAllCategories();

    CategoryDto findCategoryById(Long categoryId);

    void createCategory(CategoryRequest categoryRequest);

    void updateCategoryById(Long categoryId, CategoryRequest categoryRequest);

    void deleteCategoryById(Long categoryId);
}
