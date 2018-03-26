package com.noc.repository;

import com.noc.model.DeckCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckCardRepository extends CrudRepository<DeckCard, Long> {
}
