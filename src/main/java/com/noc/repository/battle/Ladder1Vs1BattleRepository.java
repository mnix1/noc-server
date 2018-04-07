package com.noc.repository.battle;

import com.noc.model.entity.battle.Ladder1Vs1Battle;
import com.noc.model.constant.battle.BattleStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Ladder1Vs1BattleRepository extends CrudRepository<Ladder1Vs1Battle, Long> {
    List<Ladder1Vs1Battle> findAllByStatus(BattleStatus battleStatus);
}
