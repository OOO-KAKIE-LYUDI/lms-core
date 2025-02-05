package com.lms.algo.service;

import com.lms.algo.model.dto.ProblemDto;
import com.lms.algo.model.dto.ProblemSummaryDto;
import com.lms.algo.model.entity.ProblemEntity;
import com.lms.algo.model.mapper.ProblemMapper;
import com.lms.algo.repository.ProblemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProblemService {
    private final ProblemRepository problemRepository;
    private final ProblemMapper problemMapper;

    public List<ProblemSummaryDto> getAllProblems() {
        return problemRepository.findAll()
                .stream()
                .map(problemMapper::toSummaryDto)
                .collect(Collectors.toList());
    }

    public ProblemDto getProblemById(Long id) {
        ProblemEntity problem = problemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Problem not found"));
        return problemMapper.toProblemDto(problem);
    }
}

