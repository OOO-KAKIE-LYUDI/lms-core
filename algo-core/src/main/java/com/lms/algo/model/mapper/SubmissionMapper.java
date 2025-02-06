package com.lms.algo.model.mapper;

import com.lms.algo.model.dto.CreateSubmissionDto;
import com.lms.algo.model.dto.GetSubmissionDto;
import com.lms.algo.model.dto.SendSubmissionDto;
import com.lms.algo.model.entity.LanguageEntity;
import com.lms.algo.model.entity.SubmissionEntity;
import com.lms.algo.model.entity.SubmittedTestCaseEntity;
import com.lms.algo.model.entity.TestCaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubmissionMapper {

    @Mapping(target = "problemId", source = "source.problemId")
    @Mapping(target = "code", source = "source.code")
    @Mapping(target = "userId", source = "source.userId")
    @Mapping(target = "language", source = "language")
    SubmissionEntity toEntity(CreateSubmissionDto source, LanguageEntity language);

    @Mapping(target = "submissionId", source = "source.submissionId")
    @Mapping(target = "language", source = "source.language.name")
    @Mapping(target = "code", source = "source.code")
    @Mapping(target = "problemId", source = "source.problemId")
    @Mapping(target = "userId", source = "source.userId")
    GetSubmissionDto toGetSubmissionDto(SubmissionEntity source);

}
