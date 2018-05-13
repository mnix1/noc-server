package com.noc.battle;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.noc.model.constant.card.CardType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class BattleObject implements Serializable {
    @JsonIgnore
    private int profileIndex;
    private String id;
    private CardType t;
    private String a;
    private double px;
    private double py;
    private double pz;
    private double rx;
    private double ry;
    private double rz;

    boolean isChampion() {
        return t == CardType.CHAMPION;
    }
}
