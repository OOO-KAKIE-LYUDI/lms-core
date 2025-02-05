package com.lms.algo.controller;

import com.lms.algo.entity.Submission;
import com.lms.algo.service.SubmissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/submissions")
public class SubmissionController {
    private final SubmissionService submissionService;

    public SubmissionController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @GetMapping
    public List<Submission> getAllSubmissions() {
        return submissionService.getAllSubmissions();
    }

    @PostMapping
    public Submission submitSolution(@RequestBody Submission submission) {
        return submissionService.createSubmission(submission);
    }
}
