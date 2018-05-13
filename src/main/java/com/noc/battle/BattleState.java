package com.noc.battle;

import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public class BattleState implements Serializable {
    private List<BattleObject> battleObjects = new ArrayList<>();

    public void addBattleObject(BattleObject battleObject) {
        this.battleObjects.add(battleObject);
    }

    public void moveChampion(int profileIndex, Map props) {
        BattleObject champion = battleObjects.stream()
                .filter(battleObject -> battleObject.getProfileIndex() == profileIndex && battleObject.isChampion())
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
        if (props.containsKey("moveForward")) {
            champion.setPz(champion.getPz() + 1);
        }
    }

    public Map<String, Object> prepareJson(int profileIndex) {
        Map<String, Object> state = new HashMap<>();
        state.put("my", battleObjects.stream().filter(battleObject -> battleObject.getProfileIndex() == profileIndex).collect(Collectors.toList()));
        state.put("other", battleObjects.stream().filter(battleObject -> battleObject.getProfileIndex() != profileIndex).collect(Collectors.toList()));
        return state;
    }
}
