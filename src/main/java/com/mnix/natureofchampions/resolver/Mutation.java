package com.mnix.natureofchampions.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.mnix.natureofchampions.model.Profile;
import com.mnix.natureofchampions.repository.CardRepository;
import com.mnix.natureofchampions.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class Mutation implements GraphQLMutationResolver {

    private ProfileRepository profileRepository;
    private CardRepository cardRepository;

    public Mutation(ProfileRepository profileRepository, CardRepository cardRepository) {
        this.profileRepository = profileRepository;
        this.cardRepository = cardRepository;
    }

    public Profile createProfile(String name) {
        Profile profile = new Profile(name);
        profileRepository.save(profile);
        return profile;
    }

    public Profile updateName(String tag, String name) {
        Optional<Profile> optionalProfile = profileRepository.findById(tag);
        if (!optionalProfile.isPresent()) {
            return null;
        }
        Profile profile = optionalProfile.get();
        profile.setName(name);
        profileRepository.save(profile);
        return profile;
    }
}
