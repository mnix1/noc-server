package com.noc.websocket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.socket.WebSocketSession;

@AllArgsConstructor
@Getter
public class WebSocketWrapper {

    private Long profileId;

    private WebSocketSession webSocketSession;

    String getSessionId() {
        return webSocketSession.getId();
    }

}