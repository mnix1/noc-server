package com.mnix.natureofchampions.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.mnix.natureofchampions.model.Profile;
import com.mnix.natureofchampions.repository.ProfileRepository;

import java.util.Optional;

public class Mutation implements GraphQLMutationResolver {

    private ProfileRepository profileRepository;

    public Mutation(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile createProfile(String name) {
        Profile profile = new Profile(name);
        profileRepository.save(profile);
        return profile;
    }

    public Profile updateName(Long id, String name) {
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
