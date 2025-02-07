package com.lms.algo.service;

import com.lms.algo.model.dto.ReceiveSubmittedTestCaseDto;
import com.lms.algo.model.entity.SubmissionEntity;
import com.lms.algo.model.entity.SubmittedTestCaseEntity;
import com.lms.algo.model.entity.TestCaseEntity;

import java.util.List;

public interface SubmittedTestCaseService {

    SubmittedTestCaseEntity createSubmittedTestCase(SubmissionEntity submission, TestCaseEntity testCaseEntity);
    List<SubmittedTestCaseEntity> createSubmittedTestCases(SubmissionEntity submission, List<TestCaseEntity> testCaseEntity);

    SubmittedTestCaseEntity updateSubmittedTestCase(ReceiveSubmittedTestCaseDto receiveSubmittedTestCaseDto);

    List<SubmittedTestCaseEntity> findAllBySubmission(SubmissionEntity submission);
}
