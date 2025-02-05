package com.lms.algo.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WebSocketMessage {
    private String messageType;  // SUBMISSION_RECEIVED, TESTING_COMPLETED, ERROR
    private SubmissionResult data;
}
