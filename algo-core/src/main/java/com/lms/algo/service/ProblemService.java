package com.lms.algo.service;

import com.lms.algo.model.dto.ProblemDto;
import com.lms.algo.model.entity.ProblemEntity;
import com.lms.algo.model.mapper.ProblemMapper;
import com.lms.algo.repository.ProblemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProblemService {
    private final ProblemRepository problemRepository;
    private final ProblemMapper problemMapper;

    public List<ProblemDto> getAllProblems() {
        List<ProblemEntity> problems = problemRepository.findAll();
        return problemMapper.toProblemDtoList(problems);
    }

    public ProblemDto getProblemById(Long id) {
        ProblemEntity problem = problemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Problem not found"));
        return problemMapper.toProblemDto(problem);
    }
}

