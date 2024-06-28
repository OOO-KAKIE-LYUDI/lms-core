package com.lms.core.model.mapper;

import com.lms.core.model.dto.category.CategoryDto;
import com.lms.core.model.dto.category.CategoryRequest;
import com.lms.core.model.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping(target = "categoryId", source = "categoryId"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "created", source = "createdAt"),
            @Mapping(target = "updated", source = "updatedAt")
    })
    CategoryDto toDto(CategoryEntity categoryEntity);

    @Mappings(value = {
            @Mapping(target = "name", source = "name"),
    })
    CategoryEntity toEntity(CategoryRequest source);
}

