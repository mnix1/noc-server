package com.noc.battle;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
@Getter
@AllArgsConstructor
public class BattleObject implements Serializable {
    @JsonIgnore
    private int profileIndex;
    private String id;
    private double px;
    private double py;
    private double pz;
    private double rx;
    private double ry;
    private double rz;

}
