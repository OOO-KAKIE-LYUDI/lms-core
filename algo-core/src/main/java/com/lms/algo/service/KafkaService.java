package com.lms.algo.service;

import com.lms.algo.model.dto.SubmissionResult;
import com.lms.algo.model.dto.WebSocketMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    private final SimpMessagingTemplate messagingTemplate;

    public KafkaService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @KafkaListener(topics = "submission-results", groupId = "algo-core")
    public void listenSubmissionResults(SubmissionResult result) {
        WebSocketMessage message = WebSocketMessage.builder()
                .messageType(result.getErrorMessage() == null ? "TESTING_COMPLETED" : "ERROR")
                .data(result)
                .build();

        messagingTemplate.convertAndSend("/topic/public/submission", message);
    }
}
