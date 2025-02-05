package com.lms.algo.service;

import com.lms.algo.model.entity.Submission;
import com.lms.algo.repository.SubmissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmissionService {
    private final SubmissionRepository submissionRepository;

    public SubmissionService(SubmissionRepository submissionRepository) {
        this.submissionRepository = submissionRepository;
    }

    public List<Submission> getAllSubmissions() {
        return submissionRepository.findAll();
    }

    public Submission createSubmission(Submission submission) {
        return submissionRepository.save(submission);
    }
}
