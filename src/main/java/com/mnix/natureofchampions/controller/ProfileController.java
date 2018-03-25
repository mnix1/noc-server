package com.mnix.natureofchampions.controller;

import com.mnix.natureofchampions.model.Profile;
import com.mnix.natureofchampions.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ProfileController {

    @Autowired
    ProfileRepository profileRepository;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public Map profileId(Principal user) {
        Map<String, Long> model = new HashMap<>();
        if (user == null) {
            return model;
        }
        if (user instanceof OAuth2Authentication) {
            Map<String, String> details = (Map<String, String>) ((OAuth2Authentication) user).getUserAuthentication().getDetails();
            String authId = details.get("sub");
            model.put("profileId", createOrRetrieveProfile(authId).getId());
        }
        if (user instanceof UsernamePasswordAuthenticationToken) {
            String authId = ((User) ((UsernamePasswordAuthenticationToken) user).getPrincipal()).getUsername();
            model.put("profileId", createOrRetrieveProfile(authId).getId());
        }
        return model;
    }

    private Profile createOrRetrieveProfile(String authId) {
        Profile profile = profileRepository.findByAuthId(authId);
        if (profile == null) {
            profile = new Profile(authId);
            profileRepository.save(profile);
        }
        return profile;
    }
}
