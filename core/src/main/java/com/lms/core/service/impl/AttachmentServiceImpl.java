package com.lms.core.service.impl;

import com.lms.core.model.mapper.AttachmentMapper;
import com.lms.core.repository.AttachmentRepository;
import com.lms.core.service.AttachmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AttachmentServiceImpl implements AttachmentService {

    private final AttachmentRepository attachmentRepository;
    private final AttachmentMapper attachmentMapper;
}
