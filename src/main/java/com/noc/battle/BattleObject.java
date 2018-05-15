package com.noc.battle;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.noc.model.constant.card.CardType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
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
    @JsonIgnore
    private double lastAng1;
    @JsonIgnore
    private double lastAng2;

    public BattleObject(int profileIndex, String id, CardType t, String a, double px, double py, double pz, double rx, double ry, double rz) {
        this.profileIndex = profileIndex;
        this.id = id;
        this.t = t;
        this.a = a;
        this.px = px;
        this.py = py;
        this.pz = pz;
        this.rx = rx;
        this.ry = ry;
        this.rz = rz;
    }

    @JsonIgnore
    private boolean sprint;
    private boolean dance;
    private boolean moveForward;
    private boolean moveBackward;
    private boolean moveLeft;
    private boolean moveRight;

    public boolean updatePosition(long delta) {
        double ang1 = Math.cos(this.ry) * Math.cos(this.rz);
        double ang2 = Math.sin(this.ry) * Math.cos(this.rz) * Math.cos(this.rx);
        if (moveForward) {
            if (sprint) {
                this.a = "run";
                this.pz += ang1 * delta * 3 / 800000d;
                this.px += ang2 * delta * 3 / 800000d;
            } else {
                this.a = "walk";
                this.pz += ang1 * delta / 800000d;
                this.px += ang2 * delta / 800000d;
            }
        } else if (moveBackward) {
            this.a = "walkBack";
            this.pz -= ang1 * delta / 800000d;
            this.px -= ang2 * delta / 800000d;
        } else if (moveLeft) {
            this.a = "walkLeft";
            this.pz -= ang2 * delta / 800000d;
            this.px += ang1 * delta / 800000d;
        } else if (moveRight) {
            this.a = "walkRight";
            this.pz += ang2 * delta / 800000d;
            this.px -= ang1 * delta / 800000d;
        } else if (dance) {
            this.a = "dance";
        } else if (!this.a.equals("idle") || this.lastAng1 != ang1 || this.lastAng2 != ang2) {
            this.a = "idle";
        } else {
            return false;
        }
        this.lastAng1 = ang1;
        this.lastAng2 = ang2;
        return true;
    }

    boolean isChampion() {
        return t == CardType.CHAMPION;
    }
}
