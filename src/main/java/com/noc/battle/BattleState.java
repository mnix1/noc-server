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
//        champion.setRx((Double) props.get("rx"));
//        champion.setRy((Double) props.get("ry"));
//        champion.setRz((Double) props.get("rz"));
        champion.setRx((Integer) props.get("rx") / 1000d);
        champion.setRy((Integer) props.get("ry") / 1000d);
        champion.setRz((Integer) props.get("rz") / 1000d);
        champion.setSprint(props.containsKey("sprint"));
        champion.setMoveForward(props.containsKey("moveForward"));
        champion.setMoveBackward(props.containsKey("moveBackward"));
        champion.setMoveLeft(props.containsKey("moveLeft"));
        champion.setMoveRight(props.containsKey("moveRight"));
    }

    public boolean update(long delta) {
        boolean changed = false;
        for (BattleObject battleObject : battleObjects) {
            changed |= battleObject.updatePosition(delta);
        }
        return changed;
    }

    public Map<String, Object> prepareJson(int profileIndex) {
        Map<String, Object> state = new HashMap<>();
        state.put("my", battleObjects.stream().filter(battleObject -> battleObject.getProfileIndex() == profileIndex).collect(Collectors.toList()));
        state.put("other", battleObjects.stream().filter(battleObject -> battleObject.getProfileIndex() != profileIndex).collect(Collectors.toList()));
        return state;
    }
}
