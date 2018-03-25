package com.noc.service;

import com.noc.Session;
import com.noc.model.Profile;
import com.noc.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Map;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionService {

    private Session session = new Session();

    public void setProfileId(Long profileId) {
        session.setProfileId(profileId);
    }

    public Long getProfileId() {
        return session.getProfileId();
    }

    public void checkForProfileId(Long profileId) throws IllegalAccessException {
        if (!getProfileId().equals(profileId)) {
            throw new IllegalAccessException("Wrong profileId");
        }
    }

}
