package com.lms.algo.model.dto;

import lombok.Data;

@Data
public class SendSubmissionDto {

    private Long submissionId;
    private Integer language;
    private String sourceCode;
    private String testArguments;
    private String testResults;
}
