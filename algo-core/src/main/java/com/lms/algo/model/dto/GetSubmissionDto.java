package com.lms.algo.model.dto;

import lombok.Data;

@Data
public class GetSubmissionDto {

    private Long submissionId;
    private String language;
    private String code;
    private Long problemId;
    private Long userId;
}
