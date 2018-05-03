package com.noc.resolver.root;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.noc.model.entity.social.Profile;
import com.noc.model.entity.social.Team;
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

    public Team createTeam(String name) {
        return teamService.createTeam(name);
    }

    public Profile updateProfileName(String name) {
        return profileService.updateProfileName(name);
    }
}
