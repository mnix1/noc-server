package com.noc.repository.collection;

import com.noc.model.entity.social.Profile;
import com.noc.model.entity.collection.ProfileCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileCardRepository extends CrudRepository<ProfileCard, Long> {
    Iterable<ProfileCard> findAllByProfile(Profile profile);
}
