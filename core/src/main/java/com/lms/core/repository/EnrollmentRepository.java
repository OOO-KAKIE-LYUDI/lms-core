package com.lms.core.repository;

import com.lms.core.model.entity.EnrollmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<EnrollmentEntity, Long> {
    List<EnrollmentEntity> findByCourseId(Long courseId);

    List<EnrollmentEntity> findByUserId(Long userId);
}
