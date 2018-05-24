package com.noc.battle;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.noc.helper.TagHelper;
import com.noc.model.constant.card.CardType;
import com.noc.websocket.WebSocketHandler;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class BattleChampion implements Serializable {
    private static Logger log = LoggerFactory.getLogger(BattleChampion.class);

    @JsonIgnore
    private int profileIndex;
    private String uuid;
    private String cid;
    private CardType t;
    private String a;
    private double px;
    private double py;
    private double pz;
    private double rx;
    private double ry;
    private double rz;

    public BattleChampion(int profileIndex, String cid, CardType t, String a, double px, double py, double pz, double rx, double ry, double rz) {
        this.profileIndex = profileIndex;
        this.uuid = TagHelper.randomTag();
        this.cid = cid;
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

    void setActions(List<String> actions) {
        setSprint(actions.contains("s"));
        setDance(actions.contains("d"));
        setMoveForward(actions.contains("mf"));
        setMoveBackward(actions.contains("mb"));
        setMoveLeft(actions.contains("ml"));
        setMoveRight(actions.contains("mr"));
    }

    public boolean updateAnimation() {
        String newAnimation = "idle";
        if (moveForward && !moveBackward) {
            if (sprint) {
                newAnimation = "run";
            } else {
                newAnimation = "walk";
            }
        } else if (moveBackward && !moveForward) {
            newAnimation = "walkBack";
        } else if (moveLeft && !moveRight) {
            newAnimation = "walkLeft";
        } else if (moveRight && !moveLeft) {
            newAnimation = "walkRight";
        } else if (dance) {
            newAnimation = "dance";
        }
        boolean changed = newAnimation.equals(this.a);
        this.a = newAnimation;
        return changed;
    }

    public boolean updatePosition(long delta) {
        double factor1 = Math.cos(this.ry) * Math.cos(this.rz) * delta / 1000000d;
        double factor2 = Math.sin(this.ry) * Math.cos(this.rz) * Math.cos(this.rx) * delta / 1000000d;
        double dpz = 0;
        double dpx = 0;
        if (moveForward || moveBackward || moveLeft || moveRight) {
            if (moveForward && !moveBackward) {
                if (sprint) {
                    dpz += factor1 * 3;
                    dpx += factor2 * 3;
                } else {
                    dpz += factor1;
                    dpx += factor2;
                }
            }
            if (moveBackward && !moveForward) {
                dpz -= factor1;
                dpx -= factor2;
            }
            if (moveLeft && !moveRight) {
                dpz -= factor2;
                dpx += factor1;
            }
            if (moveRight && !moveLeft) {
                dpz += factor2;
                dpx -= factor1;
            }
        } else {
            return false;
        }
        this.pz += dpz;
        this.px += dpx;
        return true;
    }

    boolean isChampion() {
        return t == CardType.CHAMPION;
    }
}
