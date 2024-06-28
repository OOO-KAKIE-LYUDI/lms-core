package com.lms.core.model.mapper;

import com.lms.core.model.dto.category.CategoryDto;
import com.lms.core.model.dto.chapter.ChapterDto;
import com.lms.core.model.dto.course.CourseDto;
import com.lms.core.model.dto.course.CourseRequest;
import com.lms.core.model.dto.course.CourseRequestUpdate;
import com.lms.core.model.dto.purchase.PurchaseDto;
import com.lms.core.model.entity.CategoryEntity;
import com.lms.core.model.entity.ChapterEntity;
import com.lms.core.model.entity.CourseEntity;
import com.lms.core.model.entity.PurchaseEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.springframework.lang.Nullable;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Mappings({
            @Mapping(source = "creator.userId", target = "userId"),
            @Mapping(source = "categoryEntity.categoryId", target = "categoryId"),
            @Mapping(source = "categoryEntity", target = "category"),
            @Mapping(source = "chapters", target = "chapters"),
            @Mapping(source = "purchases", target = "purchases")
    })
    CourseDto toDto(CourseEntity course);

    CategoryDto toDto(CategoryEntity category);

    ChapterDto toDto(ChapterEntity chapter);

    PurchaseDto toDto(PurchaseEntity purchase);

    @Mappings({
            @Mapping(target = "categoryId", source = "categoryId"),
            @Mapping(target = "title", source = "name"),
            @Mapping(target = "description", source = "description"),
    })
    CourseEntity toEntity(CourseRequest source);

    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    void updateCourseEntity(@MappingTarget CourseEntity target, @Nullable CourseRequestUpdate source);
}
