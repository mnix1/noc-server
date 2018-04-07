package com.noc.repository.battle;

import com.noc.model.constant.battle.BattleStatus;
import com.noc.model.entity.battle.Ladder1Vs1Battle;
import com.noc.model.entity.social.Profile;
import com.noc.model.entity.battle.ProfileLadder1Vs1Battle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileLadder1Vs1BattleRepository extends CrudRepository<ProfileLadder1Vs1Battle, Long> {
    List<ProfileLadder1Vs1Battle> findAllByProfile(Profile profile);
    List<ProfileLadder1Vs1Battle> findAllByLadder1Vs1Battle(Ladder1Vs1Battle ladder1Vs1Battle);
    List<ProfileLadder1Vs1Battle> findAllByProfileAndLadder1Vs1Battle_Status(Profile profile, BattleStatus battleStatus);
    List<ProfileLadder1Vs1Battle> findAllByLadder1Vs1Battle_StatusAndProfile_Ladder1Vs1BattleEloBetweenOrderByProfile_Ladder1Vs1BattleElo(BattleStatus battleStatus, Integer lowerLimit, Integer upperLimit);
}
