package com.lms.algo.service.impl;

import com.lms.algo.model.dto.ReceiveSubmittedTestCaseDto;
import com.lms.algo.model.entity.SubmissionEntity;
import com.lms.algo.model.entity.SubmittedTestCaseEntity;
import com.lms.algo.model.entity.TestCaseEntity;
import com.lms.algo.model.mapper.SubmittedTestCaseMapper;
import com.lms.algo.repository.SubmittedTestCaseRepository;
import com.lms.algo.service.JudgeIntegratorService;
import com.lms.algo.service.SubmittedTestCaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubmittedTestCaseServiceImpl implements SubmittedTestCaseService {

    private final SubmittedTestCaseRepository submittedTestCaseRepository;
    private final SubmittedTestCaseMapper submittedTestCaseMapper;
    private final JudgeIntegratorService judgeIntegratorService;

    @Override
    public SubmittedTestCaseEntity createSubmittedTestCase(SubmissionEntity submission, TestCaseEntity testCaseEntity) {
        var submittedTestCase = submittedTestCaseRepository.save(
                submittedTestCaseMapper.toEntity(submission, testCaseEntity)
        );
        judgeIntegratorService.sendToJudgeIntegrator(submittedTestCase);
        return null;
    }

    @Override
    public List<SubmittedTestCaseEntity> createSubmittedTestCases(SubmissionEntity submission, List<TestCaseEntity> testCaseEntity) {
        return null;
    }

    @Override
    public SubmittedTestCaseEntity updateSubmittedTestCase(ReceiveSubmittedTestCaseDto receiveSubmittedTestCaseDto) {
        var foundSubmittedTestCase = submittedTestCaseRepository.findBySubmittedTestCaseId(receiveSubmittedTestCaseDto.getSubmissionId());
        if (foundSubmittedTestCase.isEmpty()) {
            throw new RuntimeException("Submitted test case not found");
        }

        var submittedTestCase = foundSubmittedTestCase.get();
        submittedTestCaseMapper.update(submittedTestCase, receiveSubmittedTestCaseDto);
        submittedTestCaseRepository.save(submittedTestCase);
        return submittedTestCase;
    }

    @Override
    public List<SubmittedTestCaseEntity> findAllBySubmission(SubmissionEntity submission) {
        return submittedTestCaseRepository.findAllBySubmission(submission);
    }
}
