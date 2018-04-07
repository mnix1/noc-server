package com.noc.resolver.battle;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.noc.model.entity.battle.Ladder1Vs1Battle;
import com.noc.model.entity.battle.ProfileLadder1Vs1Battle;
import com.noc.repository.battle.ProfileLadder1Vs1BattleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Ladder1Vs1BattleResolver implements GraphQLResolver<Ladder1Vs1Battle> {

    @Autowired
    private ProfileLadder1Vs1BattleRepository profileLadder1Vs1BattleRepository;

    public Iterable<ProfileLadder1Vs1Battle> profiles(Ladder1Vs1Battle ladder1Vs1Battle) {
        return profileLadder1Vs1BattleRepository.findAllByLadder1Vs1Battle(ladder1Vs1Battle);
    }

}