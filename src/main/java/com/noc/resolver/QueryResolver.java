package com.noc.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.noc.model.Card;
import com.noc.model.CardStatistic;
import com.noc.model.Profile;
import com.noc.model.ProfileCard;
import com.noc.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueryResolver implements GraphQLQueryResolver {

    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private ProfileCardRepository profileCardRepository;
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private CardStatisticRepository cardStatisticRepository;
    @Autowired
    private DeckRepository deckRepository;
    @Autowired
    private DeckCardRepository deckCardRepository;

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

    public Card card(Long id) {
        return cardRepository.findById(id).orElse(null);
    }

    public Iterable<CardStatistic> cardStatistics() {
        return cardStatisticRepository.findAll();
    }

}