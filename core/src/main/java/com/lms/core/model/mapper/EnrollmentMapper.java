package com.lms.core.model.mapper;

import com.lms.core.model.dto.enrollment.EnrollmentDto;
import com.lms.core.model.dto.enrollment.EnrollmentRequest;
import com.lms.core.model.dto.enrollment.EnrollmentRequestUpdate;
import com.lms.core.model.entity.EnrollmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {

    @Mappings({
            @Mapping(target = "enrollmentId", source = "enrollmentId"),
            @Mapping(target = "userId", source = "userId"),
            @Mapping(target = "courseId", source = "courseId"),
            @Mapping(target = "created", source = "createdAt"),
    })
    EnrollmentDto toDto(EnrollmentEntity enrollmentEntity);

    @Mappings({
            @Mapping(target = "userId", source = "userId"),
            @Mapping(target = "courseId", source = "courseId"),
    })
    EnrollmentEntity toEntity(EnrollmentRequest enrollmentRequest);

    void updateEntity(@MappingTarget EnrollmentEntity enrollmentEntity, EnrollmentRequestUpdate enrollmentRequestUpdate);
}
