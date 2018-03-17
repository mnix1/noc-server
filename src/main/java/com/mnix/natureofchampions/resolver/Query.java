package com.mnix.natureofchampions.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.mnix.natureofchampions.model.Profile;
import com.mnix.natureofchampions.model.ProfileCard;
import com.mnix.natureofchampions.model.constant.Card;
import com.mnix.natureofchampions.repository.ProfileCardRepository;
import com.mnix.natureofchampions.repository.ProfileRepository;
import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public class Query implements GraphQLQueryResolver {

    private ProfileRepository profileRepository;
    private ProfileCardRepository profileCardRepository;

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
        return Arrays.asList(Card.values());
    }

    public Card card(String name) {
        return Card.valueOf(name);
    }

}