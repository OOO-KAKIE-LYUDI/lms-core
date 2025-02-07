package com.lms.algo.service.impl;

import com.lms.algo.model.dto.CreateSubmissionDto;
import com.lms.algo.model.dto.GetSubmissionDto;
import com.lms.algo.model.dto.ReceiveSubmittedTestCaseDto;
import com.lms.algo.model.dto.SubmissionResult;
import com.lms.algo.model.entity.SubmissionEntity;
import com.lms.algo.model.enums.SubmissionStatusEnum;
import com.lms.algo.model.enums.SubmittedTestCaseResultEnum;
import com.lms.algo.model.enums.SubmittedTestCaseStatusEnum;
import com.lms.algo.model.mapper.SubmissionMapper;
import com.lms.algo.repository.LanguageRepository;
import com.lms.algo.repository.SubmissionRepository;
import com.lms.algo.repository.TestCaseRepository;
import com.lms.algo.service.SubmissionService;
import com.lms.algo.service.SubmittedTestCaseService;
import com.lms.algo.service.WebSocketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SubmissionServiceImpl implements SubmissionService {

    private final static String LANGUAGE_NOT_FOUND_EXCEPTION_MESSAGE = "Chosen language is not supported!";

    private final LanguageRepository languageRepository;
    private final SubmissionRepository submissionRepository;
    private final SubmissionMapper submissionMapper;

    private final TestCaseRepository testCaseRepository;
    private final SubmittedTestCaseService submittedTestCaseService;
    private final WebSocketService webSocketService;

    @Override
    public List<SubmissionEntity> getAllSubmissions() {
        return submissionRepository.findAll();
    }

    @Override
    public GetSubmissionDto createSubmission(CreateSubmissionDto submissionDto) {
        var language = languageRepository.findByName(submissionDto.getLanguage());
        if (language.isEmpty()) {
            throw new RuntimeException(LANGUAGE_NOT_FOUND_EXCEPTION_MESSAGE);
        }

        var createdSubmission = submissionRepository.save(
                submissionMapper.toEntity(submissionDto, language.get())
        );

        var testCases = testCaseRepository.findAllByProblemProblemId(createdSubmission.getProblemId());
        submittedTestCaseService.createSubmittedTestCases(createdSubmission, testCases);
        return submissionMapper.toGetSubmissionDto(createdSubmission);
    }

    @Override
    public void updateSubmissionTestCase(ReceiveSubmittedTestCaseDto receiveSubmittedTestCaseDto) {
        var submittedTestCase = submittedTestCaseService.updateSubmittedTestCase(receiveSubmittedTestCaseDto);
        var submission = submittedTestCase.getSubmission();
        var submittedTestCases = submittedTestCaseService.findAllBySubmission(submission);

        var processedTestCases = submittedTestCases.stream()
                .filter(s -> SubmittedTestCaseStatusEnum.DONE.equals(s.getStatus()))
                .toList();

        if (!Objects.equals(processedTestCases.size(), submittedTestCases.size())) {
            return;
        }

        if (processedTestCases.stream().noneMatch(t -> SubmittedTestCaseResultEnum.FAIL.equals(t.getResult()))) {
            submission.setStatus(SubmissionStatusEnum.COMPLETED);
        } else {
            submission.setStatus(SubmissionStatusEnum.FAILED);
        }

        submissionRepository.save(submission);
        var s = SubmissionResult.builder()
                .submissionId(submission.getSubmissionId())
                .result(submission.getStatus().name())
                .build();
        webSocketService.sendResultToWebSocket(submission.getUserId(), s);
    }
}
