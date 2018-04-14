package com.noc.resolver.root;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.noc.model.entity.collection.Card;
import com.noc.model.entity.collection.CardStatistic;
import com.noc.model.entity.collection.Champion;
import com.noc.model.entity.social.Profile;
import com.noc.model.entity.collection.ProfileCard;
import com.noc.model.entity.social.Team;
import com.noc.repository.collection.*;
import com.noc.repository.social.ProfileRepository;
import com.noc.repository.social.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueryResolver implements GraphQLQueryResolver {
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private ProfileCardRepository profileCardRepository;
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private ChampionRepository championRepository;
    @Autowired
    private CardStatisticRepository cardStatisticRepository;
    @Autowired
    private DeckRepository deckRepository;
    @Autowired
    private DeckCardRepository deckCardRepository;

    public Iterable<Team> teams() {
        return teamRepository.findAll();
    }

    public Iterable<Profile> profiles() {
        return profileRepository.findAll();
    }

    public Profile profile(Long id) {
        return profileRepository.findById(id).orElse(null);
    }

    public Iterable<ProfileCard> profileCards() {
        return profileCardRepository.findAll();
    }

    public Iterable<Card> cards() {
        return cardRepository.findAll();
    }

    public Iterable<Champion> champions() {
        return championRepository.findAll();
    }

    public Card card(Long id) {
        return cardRepository.findById(id).orElse(null);
    }

    public Iterable<CardStatistic> cardStatistics() {
        return cardStatisticRepository.findAll();
    }

}