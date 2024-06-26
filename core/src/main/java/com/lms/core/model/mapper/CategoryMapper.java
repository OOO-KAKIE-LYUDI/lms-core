package com.lms.core.model.mapper;

import com.lms.core.model.dto.category.CategoryDto;
import com.lms.core.model.dto.category.CategoryRequest;
import com.lms.core.model.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDto createCategoryDto(Category category);

    Category createCategory(CategoryRequest categoryRequest);
}

