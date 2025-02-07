package com.lms.algo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lms.algo.model.dto.CreateSubmissionDto;
import com.lms.algo.model.dto.SubmissionResult;
import com.lms.algo.repository.TestCaseRepository;
import com.lms.algo.service.SubmissionService;
import com.lms.algo.service.WebSocketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import static com.lms.algo.model.enums.SubmissionStatusEnum.PENDING;

@Component
@RequiredArgsConstructor
@Slf4j
public class SubmissionWebSocketHandler extends TextWebSocketHandler {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final WebSocketService webSocketService;
    private final SubmissionService submissionService;
    private final TestCaseRepository testCaseRepository;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // Извлекаем параметры запроса
        String query = session.getUri().getQuery();  // Должен быть 'userId=1'
        String userIdString = null;

        if (query != null) {
            // Разбираем параметры строки запроса
            String[] queryParams = query.split("&");
            for (String param : queryParams) {
                if (param.startsWith("userId=")) {
                    userIdString = param.split("=")[1];  // Извлекаем значение параметра
                    break;
                }
            }
        }

        if (userIdString != null) {
            try {
                Long userId = Long.valueOf(userIdString);  // Преобразуем в Long
                webSocketService.addSession(userId, session);  // Добавляем сессию
                log.info("WebSocket connection established for userId: {}", userId);
            } catch (NumberFormatException e) {
                log.error("Invalid userId format in query: {}", userIdString);
                session.close(CloseStatus.BAD_DATA);  // Закрываем сессию с ошибкой
            }
        } else {
            log.error("userId parameter is missing in query");
            session.close(CloseStatus.BAD_DATA);  // Закрываем сессию с ошибкой
        }
    }


    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        CreateSubmissionDto createSubmissionDto = objectMapper.readValue(payload, CreateSubmissionDto.class);

        new Thread(() -> {
            try {
                submissionService.createSubmission(createSubmissionDto);
                log.info("Submission processing triggered for userId: {}", createSubmissionDto.getUserId());
            } catch (Exception e) {
                log.error("Error processing submission: {}", e.getMessage());
            }
        }).start();

        SubmissionResult submissionResult = SubmissionResult.builder().result(PENDING.name()).build();
        String resultJson = objectMapper.writeValueAsString(submissionResult);
        session.sendMessage(new TextMessage(resultJson));
    }
}

