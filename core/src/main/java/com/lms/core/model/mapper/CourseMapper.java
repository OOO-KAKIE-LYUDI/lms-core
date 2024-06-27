package com.lms.core.model.mapper;

import com.lms.core.model.dto.course.CourseDto;
import com.lms.core.model.dto.course.CourseRequest;
import com.lms.core.model.dto.course.CourseRequestUpdate;
import com.lms.core.model.entity.CourseEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.lang.Nullable;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseDto createCourseDto(CourseEntity course);

    CourseEntity createCourseEntity(CourseRequest source);

    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    void updateCourseEntity(@MappingTarget CourseEntity target, @Nullable CourseRequestUpdate source);
}
