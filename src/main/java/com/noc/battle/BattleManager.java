package com.noc.battle;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class BattleManager {
    private BattleWrapper battleWrapper;
    private BattleState battleState;
    private ObjectMapper objectMapper = new ObjectMapper();

    public BattleManager(BattleWrapper battleWrapper) {
        this.battleWrapper = battleWrapper;
        this.battleState = new BattleState();
        this.battleState.addBattleObject(new BattleObject(0, "albertHoop", 0, 0, -20, 0, 0, 0));
        this.battleState.addBattleObject(new BattleObject(1, "tommyBrook", 0, 0, 20, 0, Math.PI, 0));
    }

    public void start() {
        for (int i = 0; i < battleWrapper.profileConnected(); i++) {
            try {
                String battleStateJson = objectMapper.writeValueAsString(battleState.prepareJson(i));
                battleWrapper.sendMessage("BATTLE_STARTED" + battleStateJson, i);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        Flowable.interval(1000, TimeUnit.MILLISECONDS)
                .subscribe(aLong -> {
                    for (int i = 0; i < battleWrapper.profileConnected(); i++) {
                        String battleStateJson = objectMapper.writeValueAsString(battleState.prepareJson(i));
                        battleWrapper.sendMessage("BATTLE_STATE" + battleStateJson, i);
                    }
                });
    }
}
