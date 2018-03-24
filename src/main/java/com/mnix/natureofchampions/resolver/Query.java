package com.mnix.natureofchampions.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.mnix.natureofchampions.model.Card;
import com.mnix.natureofchampions.model.CardStatistic;
import com.mnix.natureofchampions.model.Profile;
import com.mnix.natureofchampions.model.ProfileCard;
import com.mnix.natureofchampions.repository.CardRepository;
import com.mnix.natureofchampions.repository.CardStatisticRepository;
import com.mnix.natureofchampions.repository.ProfileCardRepository;
import com.mnix.natureofchampions.repository.ProfileRepository;
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