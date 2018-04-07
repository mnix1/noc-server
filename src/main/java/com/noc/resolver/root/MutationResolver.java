package com.noc.resolver.root;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.noc.model.entity.battle.Ladder1Vs1Battle;
import com.noc.model.entity.social.Profile;
import com.noc.model.entity.social.Team;
import com.noc.service.battle.Ladder1Vs1BattleService;
import com.noc.service.social.ProfileService;
import com.noc.service.social.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MutationResolver implements GraphQLMutationResolver {

    @Autowired
    private TeamService teamService;
    @Autowired
    private ProfileService profileService;
    @Autowired
    private Ladder1Vs1BattleService ladder1Vs1BattleService;

    public Team createTeam(String name) {
        return teamService.createTeam(name);
    }

    public Profile updateProfileName(String name) {
        return profileService.updateProfileName(name);
    }

    public Ladder1Vs1Battle prepareLadder1Vs1Battle() throws IllegalAccessException {
        return ladder1Vs1BattleService.prepareLadder1Vs1Battle();
    }
    public Ladder1Vs1Battle cancelLadder1Vs1Battle() {
        ladder1Vs1BattleService.cancelLadder1Vs1Battle();
        return null;
    }
}
