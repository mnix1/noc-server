package com.mnix.natureofchampions.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.mnix.natureofchampions.model.Profile;
import com.mnix.natureofchampions.model.constant.Card;
import com.mnix.natureofchampions.repository.ProfileRepository;

import java.util.Arrays;


public class Query implements GraphQLQueryResolver {

    private ProfileRepository profileRepository;

    public Query(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Iterable<Profile> findAllProfiles() {
        return profileRepository.findAll();
    }

    public Profile findProfile(String tag) {
        return profileRepository.findById(tag).orElse(null);
    }

    public Iterable<Card> findAllCards() {
        return Arrays.asList(Card.values());
    }

    public Card findCard(String name) {
        return Card.valueOf(name);
    }

}