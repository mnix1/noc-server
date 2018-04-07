package com.noc.repository.social;

import com.noc.model.entity.social.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long> {

    Profile findByAuthId(String authId);
}
