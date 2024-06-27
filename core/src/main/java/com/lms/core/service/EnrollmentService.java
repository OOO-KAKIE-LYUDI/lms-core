package com.lms.core.service;

import com.lms.core.model.dto.enrollment.EnrollmentDto;
import com.lms.core.model.dto.enrollment.EnrollmentRequest;
import com.lms.core.model.dto.enrollment.EnrollmentRequestUpdate;

import java.util.List;

public interface EnrollmentService {
    List<EnrollmentDto> findAllEnrollments();

    List<EnrollmentDto> findEnrollmentsByCourseId(Long courseId);

    List<EnrollmentDto> findEnrollmentsByUserId(Long userId);

    EnrollmentDto findEnrollmentById(Long id);

    void createEnrollment(EnrollmentRequest enrollmentRequest);

    void updateEnrollmentById(Long id, EnrollmentRequestUpdate enrollmentRequest);

    void deleteEnrollmentById(Long id);
}
