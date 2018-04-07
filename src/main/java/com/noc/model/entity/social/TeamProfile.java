package com.noc.model.entity.social;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class TeamProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Boolean isLeader = false;
    private Boolean isCoLeader = false;
    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false, updatable = false)
    private Team team;
    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false, updatable = false)
    private Profile profile;

    public TeamProfile(Team team, Profile profile) {
        this.isLeader = true;
        this.team = team;
        this.profile = profile;
    }
}
