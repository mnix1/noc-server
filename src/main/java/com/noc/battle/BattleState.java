package com.noc.battle;

import lombok.Getter;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@Getter
public class BattleState implements Serializable {
    private List<BattleChampion> battleChampions = new ArrayList<>();

    public void addBattleObject(BattleChampion battleChampion) {
        this.battleChampions.add(battleChampion);
    }

    public void moveChampion(int profileIndex, Map props) {
        BattleChampion champion = battleChampions.stream()
                .filter(battleChampion -> battleChampion.getProfileIndex() == profileIndex && battleChampion.isChampion())
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
        if (props.containsKey("rx")) {
            champion.setRx((Integer) props.get("rx") / 1000d);
        }
        if (props.containsKey("ry")) {
            champion.setRy((Integer) props.get("ry") / 1000d);
        }
        if (props.containsKey("rz")) {
            champion.setRz((Integer) props.get("rz") / 1000d);
        }
        if (props.containsKey("a")) {//actions
            champion.setActions((List<String>) props.get("a"));
        } else {
            champion.setActions(Collections.emptyList());
        }
    }

    public boolean update(long delta) {
        boolean changed = false;
        for (BattleChampion battleChampion : battleChampions) {
            changed |= battleChampion.updatePosition(delta) | battleChampion.updateAnimation();
        }
        return changed;
    }

    public Map<String, Object> prepareJson(int profileIndex) {
        Map<String, Object> state = new HashMap<>();
        state.put("my", battleChampions.stream().filter(battleChampion -> battleChampion.getProfileIndex() == profileIndex).collect(Collectors.toList()));
        state.put("other", battleChampions.stream().filter(battleChampion -> battleChampion.getProfileIndex() != profileIndex).collect(Collectors.toList()));
        return state;
    }
}
