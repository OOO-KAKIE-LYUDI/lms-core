package com.lms.model.mapper;

import com.lms.model.dto.category.CategoryDto;
import com.lms.model.dto.category.CategoryRequest;
import com.lms.model.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDto createCategoryDto(Category category);

    Category createCategory(CategoryRequest categoryRequest);
}

