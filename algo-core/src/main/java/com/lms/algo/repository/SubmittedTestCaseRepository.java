package com.lms.algo.repository;

import com.lms.algo.model.entity.SubmissionEntity;
import com.lms.algo.model.entity.SubmittedTestCaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubmittedTestCaseRepository extends JpaRepository<SubmittedTestCaseEntity, Long> {

    Optional<SubmittedTestCaseEntity> findBySubmittedTestCaseId(Long id);

    List<SubmittedTestCaseEntity> findAllBySubmission(SubmissionEntity submission);
}
