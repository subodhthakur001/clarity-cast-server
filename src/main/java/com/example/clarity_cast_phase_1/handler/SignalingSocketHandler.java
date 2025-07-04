package com.example.clarity_cast_phase_1.handler;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class SignalingSocketHandler extends TextWebSocketHandler {
    private WebSocketSession senderSession = null;
    private WebSocketSession receiverSession = null;
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        JsonNode jsonMessage = mapper.readTree(message.getPayload());
        String type = jsonMessage.get("type").asText();

        switch (type) {
            case "sender":
                System.out.println("Sender added");
                senderSession = session;
                break;

            case "receiver":
                System.out.println("Receiver added");
                receiverSession = session;
                break;

            case "createOffer":
                if (session == senderSession && receiverSession != null) {
                    System.out.println("Sending offer");
                    receiverSession.sendMessage(new TextMessage(message.getPayload()));
                }
                break;

            case "createAnswer":
                if (session == receiverSession && senderSession != null) {
                    System.out.println("Sending answer");
                    senderSession.sendMessage(new TextMessage(message.getPayload()));
                }
                break;

            case "iceCandidate":
                System.out.println("Sending ICE candidate");
                if (session == senderSession && receiverSession != null) {
                    receiverSession.sendMessage(new TextMessage(message.getPayload()));
                } else if (session == receiverSession && senderSession != null) {
                    senderSession.sendMessage(new TextMessage(message.getPayload()));
                }
                break;
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        if (session == senderSession) {
            senderSession = null;
            System.out.println("Sender disconnected");
        } else if (session == receiverSession) {
            receiverSession = null;
            System.out.println("Receiver disconnected");
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) {
        System.err.println("WebSocket error: " + exception.getMessage());
    }
}
