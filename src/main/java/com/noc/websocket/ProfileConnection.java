package com.noc.websocket;

import com.noc.model.entity.social.Profile;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.socket.WebSocketSession;

@Getter
@Setter
public class ProfileConnection {

    private Long profileId;

    private Profile profile;

    private WebSocketSession webSocketSession;

    public ProfileConnection(Long profileId, WebSocketSession webSocketSession) {
        this.profileId = profileId;
        this.webSocketSession = webSocketSession;
    }

    String getSessionId() {
        return webSocketSession.getId();
    }

    @Override
    public boolean equals(Object obj) {
        return profileId.equals(((ProfileConnection) obj).profileId);
    }

}