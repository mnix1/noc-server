package com.noc.repository.collection;

import com.noc.model.entity.collection.Deck;
import com.noc.model.entity.social.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckRepository extends CrudRepository<Deck, Long> {
    Iterable<Deck> findByProfile(Profile profile);
}
