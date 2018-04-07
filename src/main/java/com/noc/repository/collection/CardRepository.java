package com.noc.repository.collection;

import com.noc.model.entity.collection.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CrudRepository<Card, Long> {
    Card findByName(String name);
}
