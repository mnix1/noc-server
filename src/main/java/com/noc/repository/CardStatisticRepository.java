package com.noc.repository;

import com.noc.model.Card;
import com.noc.model.CardStatistic;
import com.noc.model.Profile;
import com.noc.model.ProfileCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardStatisticRepository extends CrudRepository<CardStatistic, Long> {
    Iterable<CardStatistic> findByCard(Card card);
}
