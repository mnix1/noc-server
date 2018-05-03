package com.noc.resolver.social;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.noc.model.entity.collection.Deck;
import com.noc.model.entity.collection.ProfileCard;
import com.noc.model.entity.collection.ProfileChampion;
import com.noc.model.entity.social.Profile;
import com.noc.model.entity.social.TeamProfile;
import com.noc.repository.collection.DeckRepository;
import com.noc.repository.collection.ProfileCardRepository;
import com.noc.repository.collection.ProfileChampionRepository;
import com.noc.repository.social.TeamProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfileResolver implements GraphQLResolver<Profile> {
    @Autowired
    private TeamProfileRepository teamProfileRepository;
    @Autowired
    private ProfileCardRepository profileCardRepository;
    @Autowired
    private ProfileChampionRepository profileChampionRepository;
    @Autowired
    private DeckRepository deckRepository;

    public Iterable<TeamProfile> teams(Profile profile) {
        return teamProfileRepository.findAllByProfile(profile);
    }

    public Iterable<ProfileChampion> champions(Profile profile) {
        return profileChampionRepository.findAllByProfile(profile);
    }

    public Iterable<ProfileCard> cards(Profile profile) {
        return profileCardRepository.findAllByProfile(profile);
    }

    public Iterable<Deck> decks(Profile profile) {
        return deckRepository.findByProfile(profile);
    }

}