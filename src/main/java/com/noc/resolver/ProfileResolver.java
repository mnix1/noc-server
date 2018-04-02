package com.noc.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.noc.model.*;
import com.noc.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfileResolver implements GraphQLResolver<Profile> {
    @Autowired
    private ProfileCardRepository profileCardRepository;
    @Autowired
    private DeckRepository deckRepository;

    @Autowired
    private LadderBattleRepository ladderBattleRepository;

    @Autowired
    private ProfileLadderBattleRepository profileLadderBattleRepository;

    public Iterable<ProfileCard> cards(Profile profile) {
        return profileCardRepository.findByProfile(profile);
    }

    public Iterable<Deck> decks(Profile profile) {
        return deckRepository.findByProfile(profile);
    }

    public Iterable<ProfileLadderBattle> ladderBattles(Profile profile) {
        return profileLadderBattleRepository.findByProfile(profile);
    }

}