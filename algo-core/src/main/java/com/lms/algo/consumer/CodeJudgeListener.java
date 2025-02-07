package com.lms.algo.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lms.algo.model.dto.ReceiveSubmittedTestCaseDto;
import com.lms.algo.service.SubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CodeJudgeListener {

    private final SubmissionService submissionService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(
            topics = "${spring.kafka.multiple.codeJudgeProperties.template.default-topic}",
            groupId = "${spring.kafka.multiple.codeJudgeProperties.consumer.group-id}",
            concurrency = "${spring.kafka.multiple.codeJudgeProperties.listener.concurrency}",
            containerFactory = "codeJudgeListenerContainerFactory"
    )
    public void onMessage(@Payload String receiveSubmittedTestCaseDto) throws JsonProcessingException {
        var t = objectMapper.readValue(receiveSubmittedTestCaseDto, ReceiveSubmittedTestCaseDto.class);
        submissionService.updateSubmissionTestCase(t);
    }
}
