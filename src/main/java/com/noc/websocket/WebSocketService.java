package com.noc.websocket;

import com.noc.model.entity.social.Profile;
import com.noc.service.social.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class WebSocketService {
    private final CopyOnWriteArrayList<WebSocketWrapper> activeWrappers = new CopyOnWriteArrayList<WebSocketWrapper>();

    @Autowired
    ProfileService profileService;

    public void newConnection(WebSocketSession session) {
        Profile profile = profileService.createOrRetrieveProfile(profileService.getAuthId(session.getPrincipal()));
        activeWrappers.stream()
                .filter(webSocketWrapper -> webSocketWrapper.getProfileId().equals(profile.getId()))
                .findFirst()
                .ifPresent(webSocketWrapper -> {
                    try {
                        webSocketWrapper.getWebSocketSession().close();
                    } catch (IOException e) {
                    }
                });
        activeWrappers.add(new WebSocketWrapper(profile.getId(), session));
    }

    public void deleteConnection(WebSocketSession session) {
        activeWrappers.removeIf(webSocketWrapper -> webSocketWrapper.getSessionId().equals(session.getId()));
    }

    public WebSocketWrapper findBySessionId(String sessionId) {
        return activeWrappers.stream().filter(webSocketWrapper -> webSocketWrapper.getSessionId().equals(sessionId)).findFirst().get();
    }

    public WebSocketWrapper findByProfileId(Long profileId) {
        return activeWrappers.stream().filter(webSocketWrapper -> webSocketWrapper.getProfileId().equals(profileId)).findFirst().get();
    }
}
