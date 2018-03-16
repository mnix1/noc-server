package com.mnix.natureofchampions.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.mnix.natureofchampions.model.Card;
import com.mnix.natureofchampions.model.Profile;
import com.mnix.natureofchampions.repository.CardRepository;
import com.mnix.natureofchampions.repository.ProfileRepository;


public class Query implements GraphQLQueryResolver {

    private ProfileRepository profileRepository;
    private CardRepository cardRepository;

    public Query(ProfileRepository profileRepository, CardRepository cardRepository) {
        this.profileRepository = profileRepository;
        this.cardRepository = cardRepository;
    }

    public Iterable<Profile> findAllProfiles() {
        return profileRepository.findAll();
    }

    public Profile findProfile(String tag) {
        return profileRepository.findById(tag).orElse(null);
    }

    public Iterable<Card> findAllCards() {
        return cardRepository.findAll();
    }

    public Card findCard(String name) {
        return cardRepository.findById(name).orElse(null);
    }

}