package com.noc.repository;

import com.noc.model.CardStatistic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardStatisticRepository extends CrudRepository<CardStatistic, Long> {
}
