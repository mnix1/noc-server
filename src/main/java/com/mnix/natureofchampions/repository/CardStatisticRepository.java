package com.mnix.natureofchampions.repository;

import com.mnix.natureofchampions.model.CardStatistic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardStatisticRepository extends CrudRepository<CardStatistic, Long> {
}
