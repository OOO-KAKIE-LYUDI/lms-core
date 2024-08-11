package com.lms.core.model.mapper;

import com.lms.core.model.dto.assignment.AssignmentDto;
import com.lms.core.model.dto.assignment.AssignmentRequest;
import com.lms.core.model.entity.AssignmentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AssignmentMapper {

    AssignmentDto toDto(AssignmentEntity categoryEntity);

    AssignmentEntity toEntity(AssignmentRequest source);
}
