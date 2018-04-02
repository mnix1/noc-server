package com.noc.model;

import com.noc.model.constant.battle.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProfileLadderBattle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Team team;
    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false, updatable = false)
    private Profile profile;
    @ManyToOne
    @JoinColumn(name = "ladder_battle_id", nullable = false, updatable = false)
    private LadderBattle ladderBattle;
}
