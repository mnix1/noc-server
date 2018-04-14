package com.noc.resolver.collection;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.noc.model.entity.collection.*;
import com.noc.repository.collection.CardStatisticRepository;
import com.noc.repository.collection.ChampionCardRepository;
import com.noc.repository.collection.ChampionStatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChampionResolver implements GraphQLResolver<Champion> {

    @Autowired
    private ChampionStatisticRepository championStatisticRepository;
    @Autowired
    private ChampionCardRepository championCardRepository;

    public Iterable<ChampionStatistic> statistics(Champion champion) {
        return championStatisticRepository.findByChampion(champion);
    }

    public Iterable<ChampionCard> cards(Champion champion) {
        return championCardRepository.findByChampion(champion);
    }

}