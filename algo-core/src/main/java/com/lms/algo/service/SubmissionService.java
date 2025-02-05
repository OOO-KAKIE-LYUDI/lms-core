package com.lms.algo.service;

import com.lms.algo.model.entity.SubmissionEntity;
import com.lms.algo.repository.SubmissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubmissionService {

    @Autowired
    private final SubmissionRepository submissionRepository;

    public List<SubmissionEntity> getAllSubmissions() {
        return submissionRepository.findAll();
    }

    public SubmissionEntity createSubmission(SubmissionEntity submissionEntity) {
        return submissionRepository.save(submissionEntity);
    }
}
