package com.noc.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.noc.model.*;
import com.noc.repository.CardStatisticRepository;
import com.noc.repository.DeckRepository;
import com.noc.repository.ProfileCardRepository;
import lombok.AllArgsConstructor;
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