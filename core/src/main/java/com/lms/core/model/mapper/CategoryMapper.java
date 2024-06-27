package com.lms.core.model.mapper;

import com.lms.core.model.dto.category.CategoryDto;
import com.lms.core.model.dto.category.CategoryRequest;
import com.lms.core.model.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDto createCategoryDto(CategoryEntity categoryEntity);

    @Mappings(value = {
            @Mapping(target = "name", source = "name")
    })
    CategoryEntity createCategoryEntity(CategoryRequest source);
}

