package com.lms.algo.service;

import com.lms.algo.model.dto.SubmissionResult;
import org.springframework.web.socket.WebSocketSession;

public interface WebSocketService {

    void addSession(Long userId, WebSocketSession session);

    void removeSession(Long userId);

    WebSocketSession getSession(Long userId);

    void sendResultToWebSocket(Long userId, SubmissionResult result);
}
