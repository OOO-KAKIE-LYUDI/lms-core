package com.lms.algo.repository;

import com.lms.algo.model.entity.TestCaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestCaseRepository extends JpaRepository<TestCaseEntity, Long> {

    List<TestCaseEntity> findAllByProblemProblemId(Long problemId);
}
