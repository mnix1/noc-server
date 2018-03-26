package com.noc.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.noc.model.Profile;
import com.noc.repository.ProfileRepository;
import com.noc.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MutationResolver implements GraphQLMutationResolver {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private SessionService sessionService;

    public Profile updateProfileName(Long id, String name) throws IllegalAccessException {
        sessionService.checkForProfileId(id);
        Optional<Profile> optionalProfile = profileRepository.findById(id);
        if (!optionalProfile.isPresent()) {
            return null;
        }
        Profile profile = optionalProfile.get();
        profile.setName(name);
        profileRepository.save(profile);
        return profile;
    }
}
