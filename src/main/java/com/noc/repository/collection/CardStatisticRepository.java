package com.noc.repository.collection;

import com.noc.model.entity.collection.Card;
import com.noc.model.entity.collection.CardStatistic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardStatisticRepository extends CrudRepository<CardStatistic, Long> {
    Iterable<CardStatistic> findByCard(Card card);
}
