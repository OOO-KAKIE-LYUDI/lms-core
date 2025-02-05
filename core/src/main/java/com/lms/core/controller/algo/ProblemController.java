package com.lms.core.controller.algo;

import com.lms.algo.model.dto.ProblemDto;
import com.lms.algo.model.dto.ProblemSummaryDto;
import com.lms.algo.service.ProblemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/algo/problems")
public class ProblemController {
    private final ProblemService problemService;

    public ProblemController(ProblemService problemService) {
        this.problemService = problemService;
    }

    @GetMapping("/{id}")
    public ProblemDto getProblemById(@PathVariable Long id) {
        return problemService.getProblemById(id);
    }

    @GetMapping
    public List<ProblemSummaryDto> getProblems() {
        return problemService.getAllProblems();
    }
}

