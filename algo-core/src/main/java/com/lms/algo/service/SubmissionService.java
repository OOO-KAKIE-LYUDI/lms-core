package com.lms.algo.service;

import com.lms.algo.model.dto.CreateSubmissionDto;
import com.lms.algo.model.dto.GetSubmissionDto;
import com.lms.algo.model.dto.ReceiveSubmittedTestCaseDto;
import com.lms.algo.model.entity.SubmissionEntity;

import java.util.List;

public interface SubmissionService {

    List<SubmissionEntity> getAllSubmissions();

    GetSubmissionDto createSubmission(CreateSubmissionDto submissionDto);

    void updateSubmissionTestCase(ReceiveSubmittedTestCaseDto receiveSubmittedTestCaseDto);
}
