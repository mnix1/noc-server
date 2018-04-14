package com.noc.repository.collection;

import com.noc.model.entity.collection.Champion;
import com.noc.model.entity.collection.ChampionStatistic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionStatisticRepository extends CrudRepository<ChampionStatistic, Long> {
    Iterable<ChampionStatistic> findByChampion(Champion champion);
}
