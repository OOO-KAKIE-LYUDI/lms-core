package com.lms.core.controller.algo;

import com.lms.algo.model.entity.SubmissionEntity;
import com.lms.algo.service.SubmissionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/algo/submissions")
public class SubmissionController {
    private final SubmissionService submissionService;

    public SubmissionController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @GetMapping
    public List<SubmissionEntity> getAllSubmissions() {
        return submissionService.getAllSubmissions();
    }

    @PostMapping
    public SubmissionEntity submitSolution(@RequestBody SubmissionEntity submissionEntity) {
        return submissionService.createSubmission(submissionEntity);
    }
}
