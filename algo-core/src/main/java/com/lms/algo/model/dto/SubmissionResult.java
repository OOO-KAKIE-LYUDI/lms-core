package com.lms.algo.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubmissionResult {
    private String result;  // PASS, FAIL
    private String errorMessage;
    private Long testCaseId;
    private String time;
}
