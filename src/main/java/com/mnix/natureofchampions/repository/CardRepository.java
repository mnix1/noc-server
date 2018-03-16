package com.mnix.natureofchampions.repository;

import com.mnix.natureofchampions.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CrudRepository<Card, String> {
}
