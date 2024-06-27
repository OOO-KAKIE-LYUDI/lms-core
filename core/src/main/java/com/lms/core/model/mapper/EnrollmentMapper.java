package com.lms.core.model.mapper;

import com.lms.core.model.dto.enrollment.EnrollmentDto;
import com.lms.core.model.dto.enrollment.EnrollmentRequest;
import com.lms.core.model.dto.enrollment.EnrollmentRequestUpdate;
import com.lms.core.model.entity.EnrollmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {

    EnrollmentDto toDto(EnrollmentEntity enrollmentEntity);

    EnrollmentEntity toEntity(EnrollmentRequest enrollmentRequest);

    void updateEntity(@MappingTarget EnrollmentEntity enrollmentEntity, EnrollmentRequestUpdate enrollmentRequestUpdate);
}
