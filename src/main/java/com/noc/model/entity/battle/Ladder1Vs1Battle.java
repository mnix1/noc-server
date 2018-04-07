package com.noc.model.entity.battle;

import com.noc.model.constant.battle.BattleResult;
import com.noc.model.constant.battle.BattleStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
public class Ladder1Vs1Battle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BattleStatus status;
    private BattleResult result;
    @OneToMany(mappedBy = "ladder1Vs1Battle", fetch = FetchType.LAZY)
    private Set<ProfileLadder1Vs1Battle> profiles;

    public Ladder1Vs1Battle(){
        this(BattleStatus.SEARCHING_OPPONENT, BattleResult.EMPTY);
    }

    public Ladder1Vs1Battle(BattleStatus status, BattleResult result) {
        this.status = status;
        this.result = result;
        this.profiles = new HashSet<>();
    }
}
