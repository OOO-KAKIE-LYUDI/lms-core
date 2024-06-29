package com.lms.core.service.impl;

import com.lms.core.exception.LmsNotFoundException;
import com.lms.core.model.dto.enrollment.EnrollmentDto;
import com.lms.core.model.dto.enrollment.EnrollmentRequest;
import com.lms.core.model.dto.enrollment.EnrollmentRequestUpdate;
import com.lms.core.model.mapper.EnrollmentMapper;
import com.lms.core.repository.EnrollmentRepository;
import com.lms.core.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final EnrollmentMapper enrollmentMapper;

    @Override
    public List<EnrollmentDto> findAllEnrollments() {
        var enrollments = enrollmentRepository.findAll();

        if (CollectionUtils.isEmpty(enrollments)) {
            throw new LmsNotFoundException("Не найдено ни одной записи на курс");
        }

        return enrollments.stream().map(enrollmentMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<EnrollmentDto> findEnrollmentsByCourseId(Long courseId) {
        var enrollments = enrollmentRepository.findByCourseId(courseId);

        if (CollectionUtils.isEmpty(enrollments)) {
            throw new LmsNotFoundException("Не найдено ни одной записи c <courseId>=%d".formatted(courseId));
        }

        return enrollments.stream().map(enrollmentMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<EnrollmentDto> findEnrollmentsByUserId(Long userId) {
        var enrollments = enrollmentRepository.findByUserId(userId);

        if (CollectionUtils.isEmpty(enrollments)) {
            throw new LmsNotFoundException("Не найдено ни одной записи c <userId>=%d".formatted(userId));
        }

        return enrollments.stream().map(enrollmentMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public EnrollmentDto findEnrollmentById(Long id) {
        var enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new LmsNotFoundException("Не найдено ни одной записи c <id>=%d".formatted(id)));

        return enrollmentMapper.toDto(enrollment);
    }

    @Override
    public void createEnrollment(EnrollmentRequest enrollmentRequest) {
        var enrollmentEntity = enrollmentMapper.toEntity(enrollmentRequest);
        enrollmentRepository.save(enrollmentEntity);
    }

    @Override
    public void updateEnrollmentById(Long id, EnrollmentRequestUpdate enrollmentRequest) {
        var enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new LmsNotFoundException("Не найдено ни одной записи c <id>=%d".formatted(id)));

        enrollmentMapper.updateEntity(enrollment, enrollmentRequest);
        enrollmentRepository.save(enrollment);
    }

    @Override
    public void deleteEnrollmentById(Long id) {
        if (!enrollmentRepository.existsById(id)) {
            throw new LmsNotFoundException("Не найдено ни одной записи c <id>=%d".formatted(id));
        }
        enrollmentRepository.deleteById(id);
    }
}

