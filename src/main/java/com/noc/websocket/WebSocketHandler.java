package com.noc.websocket;

import com.noc.battle.initialize.BattleService;
import com.noc.service.social.ProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebSocketHandler extends TextWebSocketHandler {

    private static Logger log = LoggerFactory.getLogger(WebSocketHandler.class);

    @Autowired
    BattleService battleService;
    @Autowired
    ProfileService profileService;
    @Autowired
    WebSocketService webSocketService;

    @Override
    public void handleTransportError(WebSocketSession session, Throwable throwable) throws Exception {
        log.error("error occured at sender " + session, throwable);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info(String.format("Session %s closed because of %s", session.getId(), status.getReason()));
        webSocketService.deleteConnection(session);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("Connected: sessionId: " + session.getId());
        webSocketService.newConnection(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage jsonTextMessage) throws Exception {
        String message = jsonTextMessage.getPayload();
        log.debug("Message received: " + jsonTextMessage.getPayload() + ", from sessionId: " + session.getId());
        if (message.equals("START_BATTLE")) {
            battleService.prepareBattle(profileService.getProfile(webSocketService.findBySessionId(session.getId()).getProfileId()));
        } else if (message.equals("CANCEL_BATTLE")) {
            battleService.cancelBattle(profileService.getProfile(webSocketService.findBySessionId(session.getId()).getProfileId()));
        }
    }
}