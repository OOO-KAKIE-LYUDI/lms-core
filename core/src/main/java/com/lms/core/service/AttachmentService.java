package com.lms.core.service;

import com.lms.core.model.dto.attacment.AttachmentDto;
import com.lms.core.model.dto.attacment.AttachmentRequest;
import com.lms.core.model.dto.attacment.AttachmentRequestUpdate;

import java.util.List;

public interface AttachmentService {
    List<AttachmentDto> findAllAttachments();

    List<AttachmentDto> findAttachmentsByChapterId(Long chapterId);

    AttachmentDto findAttachmentById(Long id);

    void createAttachment(AttachmentRequest attachmentRequest);

    void updateAttachmentById(Long id, AttachmentRequestUpdate attachmentRequest);

    void deleteAttachmentById(Long id);
}
