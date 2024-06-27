package com.lms.core.repository;

import com.lms.core.model.entity.EnrollmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrolmentRepository extends JpaRepository<EnrollmentEntity, Long> {
}
