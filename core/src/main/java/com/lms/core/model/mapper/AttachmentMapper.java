package com.lms.core.model.mapper;

import com.lms.core.model.dto.attacment.AttachmentDto;
import com.lms.core.model.dto.attacment.AttachmentRequest;
import com.lms.core.model.dto.attacment.AttachmentRequestUpdate;
import com.lms.core.model.entity.AttachmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface AttachmentMapper {

    @Mappings({
            @Mapping(target = "attachmentId", source = "attachmentId"),
            @Mapping(target = "chapterId", source = "courseId"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "type", source = "type"),
            @Mapping(target = "fileId", source = "fileId"),
            @Mapping(target = "created", source = "createdAt"),
            @Mapping(target = "updated", source = "updatedAt"),
            @Mapping(target = "position", source = "position"),
    })
    AttachmentDto toDto(AttachmentEntity attachmentEntity);

    @Mappings({
            @Mapping(target = "courseId", source = "chapterId"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "type", source = "type"),
            @Mapping(target = "fileId", source = "fileId"),
            @Mapping(target = "position", source = "position"),
    })
    AttachmentEntity toEntity(AttachmentRequest attachmentRequest);

    void updateEntity(@MappingTarget AttachmentEntity attachmentEntity, AttachmentRequestUpdate attachmentRequestUpdate);
}
