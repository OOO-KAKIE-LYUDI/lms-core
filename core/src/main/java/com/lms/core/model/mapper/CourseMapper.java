package com.lms.core.model.mapper;

import com.lms.core.model.dto.course.CourseDto;
import com.lms.core.model.dto.course.CourseRequest;
import com.lms.core.model.dto.course.CourseRequestUpdate;
import com.lms.core.model.entity.CourseEntity;
import org.mapstruct.*;
import org.springframework.lang.Nullable;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Mappings({
            @Mapping(target = "courseId", source = "courseId"),
            @Mapping(target = "categoryId", source = "categoryId"),
            @Mapping(target = "creatorId", source = "creatorId"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "description", source = "description"),
            @Mapping(target = "created", source = "created"),
            @Mapping(target = "updated", source = "updated"),
    })
    CourseDto toDto(CourseEntity course);

    @Mappings({
            @Mapping(target = "courseId", source = "courseId"),
            @Mapping(target = "categoryId", source = "categoryId"),
            @Mapping(target = "creatorId", source = "creatorId"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "description", source = "description"),
            @Mapping(target = "created", source = "created"),
            @Mapping(target = "updated", source = "updated"),
    })
    CourseEntity toEntity(CourseRequest source);

    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    void updateCourseEntity(@MappingTarget CourseEntity target, @Nullable CourseRequestUpdate source);
}
