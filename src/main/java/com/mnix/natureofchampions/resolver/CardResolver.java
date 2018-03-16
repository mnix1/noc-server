package com.mnix.natureofchampions.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.mnix.natureofchampions.model.Card;
import com.mnix.natureofchampions.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CardResolver implements GraphQLResolver<Card> {
    @Autowired
    private CardRepository cardRepository;

}
