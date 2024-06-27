package com.lms.core.model.mapper;

import com.lms.core.model.dto.attacment.AttachmentDto;
import com.lms.core.model.dto.attacment.AttachmentRequest;
import com.lms.core.model.dto.attacment.AttachmentRequestUpdate;
import com.lms.core.model.entity.AttachmentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AttachmentMapper {

    AttachmentDto toDto(AttachmentEntity attachmentEntity);

    AttachmentEntity toEntity(AttachmentRequest attachmentRequest);

    void updateEntity(AttachmentEntity attachmentEntity, AttachmentRequestUpdate attachmentRequestUpdate);
}
