package com.noc.repository.social;

import com.noc.model.entity.social.Profile;
import com.noc.model.entity.social.TeamProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamProfileRepository extends CrudRepository<TeamProfile, Long> {
    Iterable<TeamProfile> findAllByProfile(Profile profile);
}
