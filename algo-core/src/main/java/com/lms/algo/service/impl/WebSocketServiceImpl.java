package com.lms.algo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lms.algo.model.dto.SubmissionResult;
import com.lms.algo.service.WebSocketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
@Slf4j
public class WebSocketServiceImpl implements WebSocketService {
    private final Map<Long, WebSocketSession> sessions = new ConcurrentHashMap<>();
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void addSession(Long userId, WebSocketSession session) {
        sessions.put(userId, session);
    }

    @Override
    public void removeSession(Long userId) {
        sessions.remove(userId);
    }

    @Override
    public WebSocketSession getSession(Long userId) {
        return sessions.get(userId);
    }

    @Override
    public void sendResultToWebSocket(Long userId, SubmissionResult result) {
        WebSocketSession session = sessions.get(userId);
        if (session != null && session.isOpen()) {
            try {
                session.sendMessage(new TextMessage(mapper.writeValueAsString(result)));
            } catch (IOException e) {
                log.error("Error sending result to WebSocket: {}", e.getMessage());
            }
        }
    }
}
