package com.durgesh.websoket.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

@Slf4j
public class MyHandler implements WebSocketHandler {
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("Connection Establish on session : {}",session.getId());
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        String messagePayloads=message.getPayload().toString();
        log.info("Message : {}",messagePayloads);
        session.sendMessage(new TextMessage("Stated Message :  "+ session+"-"+messagePayloads));
        Thread.sleep(1000);
        session.sendMessage(new TextMessage("Complete Message :   "+messagePayloads ));
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        log.info("Exception occurred : {} on session : {}",exception.getMessage(),session.getId());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        log.info("connection close on session :{} with status ",session.getId(),closeStatus.getCode());

    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
