package com.lms.core.controller.algo;

import com.lms.algo.model.dto.CreateSubmissionDto;
import com.lms.algo.model.dto.GetSubmissionDto;
import com.lms.algo.model.entity.SubmissionEntity;
import com.lms.algo.service.impl.SubmissionServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/algo/submissions")
public class SubmissionController {
    private final SubmissionServiceImpl submissionServiceImpl;

    public SubmissionController(SubmissionServiceImpl submissionServiceImpl) {
        this.submissionServiceImpl = submissionServiceImpl;
    }

    @GetMapping
    public List<SubmissionEntity> getAllSubmissions() {
        return submissionServiceImpl.getAllSubmissions();
    }

    @PostMapping
    public GetSubmissionDto submitSolution(@RequestBody CreateSubmissionDto submissionEntity) {
        return submissionServiceImpl.createSubmission(submissionEntity);
    }
}
