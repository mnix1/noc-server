package com.mnix.natureofchampions.repository;

import com.mnix.natureofchampions.model.ProfileCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileCardRepository extends CrudRepository<ProfileCard, Long> {
}
