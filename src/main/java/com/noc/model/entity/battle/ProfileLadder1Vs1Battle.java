package com.noc.model.entity.battle;

import com.noc.model.constant.battle.BattleSide;
import com.noc.model.entity.social.Profile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class ProfileLadder1Vs1Battle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BattleSide side;
    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false, updatable = false)
    private Profile profile;
    @ManyToOne
    @JoinColumn(name = "ladder_1_vs_1_battle_id", nullable = false, updatable = false)
    private Ladder1Vs1Battle ladder1Vs1Battle;

    public ProfileLadder1Vs1Battle(BattleSide side, Profile profile, Ladder1Vs1Battle ladder1Vs1Battle) {
        this.side = side;
        this.profile = profile;
        this.ladder1Vs1Battle = ladder1Vs1Battle;
    }
}
