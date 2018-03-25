package com.noc.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.noc.model.Card;
import com.noc.model.CardStatistic;
import com.noc.model.Profile;
import com.noc.model.ProfileCard;
import com.noc.repository.CardRepository;
import com.noc.repository.CardStatisticRepository;
import com.noc.repository.ProfileCardRepository;
import com.noc.repository.ProfileRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Query implements GraphQLQueryResolver {

    private ProfileRepository profileRepository;
    private ProfileCardRepository profileCardRepository;

    private CardRepository cardRepository;
    private CardStatisticRepository cardStatisticRepository;

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