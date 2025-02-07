package com.lms.algo.model.dto;

import lombok.Data;

@Data
public class ReceiveSubmittedTestCaseDto {

    private Long submissionId;
    private Long codeJudgeId;
    private String status;
    private Integer result;
    private String resultMessage;
}
