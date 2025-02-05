package com.lms.algo.model.mapper;

import com.lms.algo.model.dto.ExampleDto;
import com.lms.algo.model.dto.ProblemDto;
import com.lms.algo.model.dto.ProblemSummaryDto;
import com.lms.algo.model.entity.ExampleEntity;
import com.lms.algo.model.entity.ProblemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProblemMapper {

    // Преобразование ProblemEntity → ProblemDto
    @Mapping(source = "examples", target = "examples")
    @Mapping(source = "problemId", target = "id")
    ProblemDto toProblemDto(ProblemEntity entity);

    List<ProblemDto> toProblemDtoList(List<ProblemEntity> entities);

    // Преобразование ExampleEntity → ExampleDto
    @Mapping(source = "exampleId", target = "id")
    ExampleDto toExampleDto(ExampleEntity entity);

    List<ExampleDto> toExampleDtoList(List<ExampleEntity> entities);

    @Mapping(source = "problemId", target = "id")
    @Mapping(target = "link", ignore = true)
    ProblemSummaryDto toSummaryDto(ProblemEntity entity);

    List<ProblemSummaryDto> toSummaryDtoList(List<ProblemEntity> entities);
}
