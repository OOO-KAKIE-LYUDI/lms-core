package com.lms.algo.model.mapper;

import com.lms.algo.model.dto.ReceiveSubmittedTestCaseDto;
import com.lms.algo.model.dto.SendSubmissionDto;
import com.lms.algo.model.entity.SubmissionEntity;
import com.lms.algo.model.entity.SubmittedTestCaseEntity;
import com.lms.algo.model.entity.TestCaseEntity;
import com.lms.algo.model.enums.SubmittedTestCaseResultEnum;
import com.lms.algo.model.enums.SubmittedTestCaseStatusEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", imports = {
        SubmittedTestCaseStatusEnum.class, SubmittedTestCaseResultEnum.class, SubmittedTestCaseResultEnum.SubmittedTestCaseExternalResultEnum.class
})
public interface SubmittedTestCaseMapper {

    @Mapping(target = "submissionId", source = "submission.submissionId")
    @Mapping(target = "testCaseId", source = "testCase.testCaseId")
    @Mapping(target = "status", expression = "java(SubmittedTestCaseStatusEnum.WAIT)")
    SubmittedTestCaseEntity toEntity(SubmissionEntity submission, TestCaseEntity testCase);

    @Mapping(target = "submissionId", source = "source.submittedTestCaseId")
    @Mapping(target = "language", source = "source.submission.language.judgeCode")
    @Mapping(target = "sourceCode", source = "source.submission.code")
    @Mapping(target = "testArguments", source = "source.testCase.inputText")
    @Mapping(target = "testResults", source = "source.testCase.outputText")
    SendSubmissionDto toSendSubmissionDto(SubmittedTestCaseEntity source);

    @Mapping(target = "submittedTestCaseEntity.result", expression = "java(SubmittedTestCaseResultEnum.getByExternalValue(SubmittedTestCaseResultEnum.SubmittedTestCaseExternalResultEnum.getByValue(receiveSubmittedTestCaseDto.getResult())))")
    @Mapping(target = "submittedTestCaseEntity.status", expression = "java(SubmittedTestCaseStatusEnum.DONE)")
    @Mapping(target = "submittedTestCaseEntity.resultMessage", source = "receiveSubmittedTestCaseDto.resultMessage")
    @Mapping(target = "submittedTestCaseEntity.judgeIntegratorId", source = "receiveSubmittedTestCaseDto.codeJudgeId")
    void update(@MappingTarget SubmittedTestCaseEntity submittedTestCaseEntity, ReceiveSubmittedTestCaseDto receiveSubmittedTestCaseDto);
}
