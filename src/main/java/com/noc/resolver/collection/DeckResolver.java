package com.noc.resolver.collection;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.noc.model.entity.collection.Card;
import com.noc.model.entity.collection.CardStatistic;
import com.noc.model.entity.collection.Deck;
import com.noc.model.entity.collection.DeckCard;
import com.noc.repository.collection.CardStatisticRepository;
import com.noc.repository.collection.DeckCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeckResolver implements GraphQLResolver<Deck> {

    @Autowired
    private DeckCardRepository deckCardRepository;

    public Iterable<DeckCard> cards(Deck deck) {
        return deckCardRepository.findByDeck(deck);
    }

}