package com.noc.repository;

import com.noc.model.LadderBattle;
import com.noc.model.Profile;
import com.noc.model.constant.battle.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LadderBattleRepository extends CrudRepository<LadderBattle, Long> {
    List<LadderBattle> findAllByStatus(Status status);
}
