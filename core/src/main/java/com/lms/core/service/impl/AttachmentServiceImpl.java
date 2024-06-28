package com.lms.core.service.impl;

import com.lms.core.exception.LmsNotFoundException;
import com.lms.core.model.dto.attacment.AttachmentDto;
import com.lms.core.model.dto.attacment.AttachmentRequest;
import com.lms.core.model.dto.attacment.AttachmentRequestUpdate;
import com.lms.core.model.mapper.AttachmentMapper;
import com.lms.core.repository.AttachmentRepository;
import com.lms.core.service.AttachmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AttachmentServiceImpl implements AttachmentService {

    private final AttachmentRepository attachmentRepository;
    private final AttachmentMapper attachmentMapper;

    @Override
    public List<AttachmentDto> findAllAttachments() {
        var attachments = attachmentRepository.findAll();

        if (CollectionUtils.isEmpty(attachments)) {
            throw new LmsNotFoundException("No attachments found");
        }

        return attachments.stream().map(attachmentMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<AttachmentDto> findAttachmentsByChapterId(Long chapterId) {
        var attachments = attachmentRepository.findByCourseId(chapterId);

        if (CollectionUtils.isEmpty(attachments)) {
            throw new LmsNotFoundException("No attachments found for chapter id: " + chapterId);
        }

        return attachments.stream().map(attachmentMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public AttachmentDto findAttachmentById(Long id) {
        var attachment = attachmentRepository.findById(id)
                .orElseThrow(() -> new LmsNotFoundException("Attachment not found with id: " + id));

        return attachmentMapper.toDto(attachment);
    }

    @Override
    public void createAttachment(AttachmentRequest attachmentRequest) {
        var attachmentEntity = attachmentMapper.toEntity(attachmentRequest);
        attachmentRepository.save(attachmentEntity);
    }

    @Override
    public void updateAttachmentById(Long id, AttachmentRequestUpdate attachmentRequest) {
        var attachment = attachmentRepository.findById(id)
                .orElseThrow(() -> new LmsNotFoundException("Attachment not found with id: " + id));

        attachmentMapper.updateEntity(attachment, attachmentRequest);
        attachmentRepository.save(attachment);
    }

    @Override
    public void deleteAttachmentById(Long id) {
        if (!attachmentRepository.existsById(id)) {
            throw new LmsNotFoundException("Attachment not found with id: " + id);
        }
        attachmentRepository.deleteById(id);
    }
}

