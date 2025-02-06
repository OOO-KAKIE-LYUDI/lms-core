package com.lms.algo.service;

import com.lms.algo.model.dto.ProblemDto;
import com.lms.algo.model.dto.ProblemSummaryDto;

import java.util.List;

public interface ProblemService {

    List<ProblemSummaryDto> getAllProblems();
    ProblemDto getProblemById(Long id);
}
