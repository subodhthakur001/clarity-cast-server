package com.example.clarity_cast_phase_1.config;

import com.example.clarity_cast_phase_1.handler.SignalingSocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new SignalingSocketHandler(), "/signal")
                .setAllowedOrigins("*");
    }
}
