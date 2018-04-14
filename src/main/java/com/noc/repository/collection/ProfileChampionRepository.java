package com.noc.repository.collection;

import com.noc.model.entity.collection.ProfileChampion;
import com.noc.model.entity.social.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileChampionRepository extends CrudRepository<ProfileChampion, Long> {
    Iterable<ProfileChampion> findAllByProfile(Profile profile);
}
