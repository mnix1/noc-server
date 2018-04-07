package com.noc.resolver.collection;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.noc.model.entity.collection.Card;
import com.noc.model.entity.collection.CardStatistic;
import com.noc.repository.collection.CardStatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CardResolver implements GraphQLResolver<Card> {

    @Autowired
    private CardStatisticRepository cardStatisticRepository;

    public Iterable<CardStatistic> statistics(Card card) {
        return cardStatisticRepository.findByCard(card);
    }

}