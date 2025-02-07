package com.lms.algo.service;

import com.lms.algo.model.dto.SendSubmissionDto;
import com.lms.algo.model.entity.SubmissionEntity;
import com.lms.algo.model.entity.SubmittedTestCaseEntity;

import java.util.List;

public interface JudgeIntegratorService {

    void sendToJudgeIntegrator(SubmittedTestCaseEntity submittedTestCase);
    void sendManyToJudgeIntegrator(List<SubmittedTestCaseEntity> submittedTestCases);
}
