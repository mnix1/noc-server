package com.noc.repository.collection;

import com.noc.model.entity.collection.DeckCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckCardRepository extends CrudRepository<DeckCard, Long> {
}
