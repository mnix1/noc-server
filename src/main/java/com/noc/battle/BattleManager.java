package com.noc.battle;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.noc.model.constant.battle.BattleStatus;
import com.noc.model.constant.card.CardType;
import com.noc.websocket.ProfileConnection;
import io.reactivex.Flowable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BattleManager {
    private BattleWrapper battleWrapper;
    private BattleState battleState;
    private Map<String, Integer> sessionIdToProfileIndexMap = new HashMap<String, Integer>();
    private ObjectMapper objectMapper = new ObjectMapper();

    public BattleManager(BattleWrapper battleWrapper) {
        this.battleWrapper = battleWrapper;
        this.battleState = new BattleState();
        battleWrapper.getProfileConnections().forEach(profileConnection -> {
            sessionIdToProfileIndexMap.put(profileConnection.getWebSocketSession().getId(), sessionIdToProfileIndexMap.size());
        });
        this.battleState.addBattleObject(new BattleChampion(0, "albertHoop", CardType.CHAMPION, "idle", 0, 0, -14, 0, 0, 0));
        this.battleState.addBattleObject(new BattleChampion(1, "tommyBrook", CardType.CHAMPION, "idle", 0, 0, 14, 0, Math.PI, 0));
    }

    public void ready() {
        for (int i = 0; i < battleWrapper.profileConnected(); i++) {
            try {
                String battleStateJson = objectMapper.writeValueAsString(battleState.prepareJson(i));
                battleWrapper.sendMessage("BATTLE_SERVER_READY" + battleStateJson, i);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }

    public void maybeStart(String sessionId) {
        battleWrapper.getProfileConnections().forEach(profileConnection -> {
            if (profileConnection.getWebSocketSession().getId().equals(sessionId)) {
                profileConnection.setReady(true);
            }
        });
        if (battleWrapper.getProfileConnections().stream().filter(ProfileConnection::isReady).toArray().length == battleWrapper.profileConnected()) {
            battleWrapper.setBattleStatus(BattleStatus.IN_PROGRESS);
            battleWrapper.sendMessage("BATTLE_IN_PROGRESS");
            start();
        }
    }

    public void move(String sessionId, Map<String, Object> props) {
        battleState.moveChampion(sessionIdToProfileIndexMap.get(sessionId), props);
    }

    public void start() {
        int tick = 25;
        long interval = (long) 1000000d / tick;
        Flowable.interval(interval, TimeUnit.MICROSECONDS)
                .map(aLong -> battleState.update(interval))
                .subscribe(changed -> {
                    if (changed) {
                        for (int i = 0; i < battleWrapper.profileConnected(); i++) {
                            String battleStateJson = objectMapper.writeValueAsString(battleState.prepareJson(i));
                            battleWrapper.sendMessage("BATTLE_STATE" + battleStateJson, i);
                        }
                    }
                });
    }
}
