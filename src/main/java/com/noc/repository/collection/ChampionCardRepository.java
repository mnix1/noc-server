package com.noc.repository.collection;

import com.noc.model.entity.collection.Champion;
import com.noc.model.entity.collection.ChampionCard;
import com.noc.model.entity.collection.ChampionStatistic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionCardRepository extends CrudRepository<ChampionCard, Long> {
    Iterable<ChampionCard> findByChampion(Champion champion);
}
