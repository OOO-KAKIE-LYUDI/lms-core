package com.lms.algo.configuration;

import com.lms.algo.service.impl.SubmissionWebSocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

//@Configuration
//@EnableWebSocket
//public class WebSocketConfig implements WebSocketConfigurer {
//
//    private final SubmissionWebSocketHandler submissionWebSocketHandler;
//
//    public WebSocketConfig(SubmissionWebSocketHandler submissionWebSocketHandler) {
//        this.submissionWebSocketHandler = submissionWebSocketHandler;
//    }
//
//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//        registry.addHandler(submissionWebSocketHandler, "/ws/submit")
//                .setAllowedOrigins("*")  // Разрешаем все источники (для разработки, можно настроить по-другому)
//                .addInterceptors(new HttpSessionHandshakeInterceptor()); // Можно добавить обработчик интерсептора для сессий, если нужно
//    }
//}


