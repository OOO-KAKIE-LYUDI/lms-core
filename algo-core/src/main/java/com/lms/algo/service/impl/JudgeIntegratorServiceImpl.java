package com.lms.algo.service.impl;

import com.lms.algo.feign.JudgeIntegratorFeignClient;
import com.lms.algo.model.entity.SubmittedTestCaseEntity;
import com.lms.algo.model.mapper.SubmittedTestCaseMapper;
import com.lms.algo.service.JudgeIntegratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@RequiredArgsConstructor
public class JudgeIntegratorServiceImpl implements JudgeIntegratorService {

    private final static Integer NUMBER_OF_THREADS = 10;

    private final JudgeIntegratorFeignClient judgeIntegratorFeignClient;
    private final SubmittedTestCaseMapper submittedTestCaseMapper;

    private final ExecutorService fixedThreadPool = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    @Override
    public void sendToJudgeIntegrator(SubmittedTestCaseEntity submittedTestCase) {
        fixedThreadPool.submit(
                () -> judgeIntegratorFeignClient.sendSubmission(
                        submittedTestCaseMapper.toSendSubmissionDto(submittedTestCase)));
    }

    @Override
    public void sendManyToJudgeIntegrator(List<SubmittedTestCaseEntity> submittedTestCases) {
        submittedTestCases.forEach(this::sendToJudgeIntegrator);
    }
}
