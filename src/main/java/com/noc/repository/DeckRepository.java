package com.noc.repository;

import com.noc.model.Deck;
import com.noc.model.Profile;
import com.noc.model.ProfileCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckRepository extends CrudRepository<Deck, Long> {
    Iterable<Deck> findByProfile(Profile profile);
}
