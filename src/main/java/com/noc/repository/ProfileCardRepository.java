package com.noc.repository;

import com.noc.model.ProfileCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileCardRepository extends CrudRepository<ProfileCard, Long> {
}
