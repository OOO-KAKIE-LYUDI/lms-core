package com.lms.algo.controller;

import com.lms.algo.model.dto.SubmissionResult;
import com.lms.algo.model.dto.WebSocketMessage;
import com.lms.algo.model.entity.Submission;
import com.lms.algo.service.SubmissionService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketSubmissionController {
    private final SimpMessagingTemplate messagingTemplate;
    private final SubmissionService submissionService;

    public WebSocketSubmissionController(SimpMessagingTemplate messagingTemplate, SubmissionService submissionService) {
        this.messagingTemplate = messagingTemplate;
        this.submissionService = submissionService;
    }

    @MessageMapping("/submit")
    public void submitSolution(Submission submission) {
        Submission savedSubmission = submissionService.createSubmission(submission);

        // Отправляем событие "SUBMISSION_RECEIVED" клиенту
        WebSocketMessage submissionReceived = WebSocketMessage.builder()
                .messageType("SUBMISSION_RECEIVED")
                .data(SubmissionResult.builder()
                        .result("queued")
                        .errorMessage(null)
                        .testCaseId(null)
                        .time(String.valueOf(System.currentTimeMillis()))
                        .build())
                .build();

        messagingTemplate.convertAndSend("/topic/public/submission", submissionReceived);
    }
}

