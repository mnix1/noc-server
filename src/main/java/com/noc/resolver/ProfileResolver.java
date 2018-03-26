package com.noc.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.noc.model.Card;
import com.noc.model.Deck;
import com.noc.model.Profile;
import com.noc.model.ProfileCard;
import com.noc.repository.CardRepository;
import com.noc.repository.DeckRepository;
import com.noc.repository.ProfileCardRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfileResolver implements GraphQLResolver<Profile> {
    @Autowired
    private ProfileCardRepository profileCardRepository;
    @Autowired
    private DeckRepository deckRepository;

    public Iterable<ProfileCard> cards(Profile profile) {
        return profileCardRepository.findByProfile(profile);
    }

    public Iterable<Deck> decks(Profile profile) {
        return deckRepository.findByProfile(profile);
    }

}