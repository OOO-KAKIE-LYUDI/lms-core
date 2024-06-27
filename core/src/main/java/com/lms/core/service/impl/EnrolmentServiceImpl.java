package com.lms.core.service.impl;

import com.lms.core.model.mapper.EnrolmentMapper;
import com.lms.core.repository.EnrolmentRepository;
import com.lms.core.service.EnrolmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EnrolmentServiceImpl implements EnrolmentService {

    private final EnrolmentRepository enrolmentRepository;
    private final EnrolmentMapper enrolmentMapper;
}
