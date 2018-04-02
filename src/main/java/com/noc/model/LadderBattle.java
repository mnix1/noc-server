package com.noc.model;

import com.noc.model.constant.battle.Result;
import com.noc.model.constant.battle.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class LadderBattle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy = "ladderBattle", fetch = FetchType.LAZY)
    private Set<ProfileLadderBattle> profiles;
    private Status status;
    private Result result;
}
