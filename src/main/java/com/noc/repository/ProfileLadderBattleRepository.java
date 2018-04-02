package com.noc.repository;

import com.noc.model.Profile;
import com.noc.model.ProfileCard;
import com.noc.model.ProfileLadderBattle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileLadderBattleRepository extends CrudRepository<ProfileLadderBattle, Long> {
    Iterable<ProfileLadderBattle> findByProfile(Profile profile);
}
