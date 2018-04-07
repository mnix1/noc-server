package com.noc.service.social;

import com.noc.model.entity.social.Profile;
import com.noc.model.entity.social.Team;
import com.noc.model.entity.social.TeamProfile;
import com.noc.repository.social.TeamProfileRepository;
import com.noc.repository.social.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private TeamProfileRepository teamProfileRepository;

    public Team createTeam(String name) {
        Profile profile = profileService.getProfile();
        Team team = new Team(name);
        teamRepository.save(team);
        TeamProfile teamProfile = new TeamProfile(team, profile);
        teamProfileRepository.save(teamProfile);
        return team;
    }
}
