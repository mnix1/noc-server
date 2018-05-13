package com.noc.battle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.noc.service.social.ProfileService;
import com.noc.websocket.ProfileConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class BattleService {
    private CopyOnWriteArrayList<BattleWrapper> activeBattleWrappers = new CopyOnWriteArrayList<BattleWrapper>();
    private ConcurrentHashMap<String, BattleManager> activeBattleManagers = new ConcurrentHashMap<>();

    @Autowired
    private ProfileService profileService;

    public BattleWrapper createBattle(ProfileConnection profileConnection) {
        Optional<BattleWrapper> battleInfoOptional = activeBattleWrappers.stream()
                .filter(BattleWrapper::isSearchingOpponentStatus)
                .findFirst();
        if (battleInfoOptional.isPresent()) {
            BattleWrapper battleWrapper = battleInfoOptional.get();
            battleWrapper.prepareBattle(profileConnection);
            return battleWrapper;
        }
        BattleWrapper battleWrapper = new BattleWrapper(profileConnection);
        activeBattleWrappers.add(battleWrapper);
        return battleWrapper;
    }

    public void cancelBattle(final ProfileConnection profileConnection) {
        activeBattleWrappers.removeIf(battleWrapper -> battleWrapper.isForProfile(profileConnection));
    }

    public void prepareBattle(BattleWrapper battleWrapper) {
        battleWrapper.sendMessage("BATTLE_PREPARING");
        battleWrapper.updateProfileConnections(profileService);
        BattleManager battleManager = new BattleManager(battleWrapper);
        battleWrapper.getProfileConnections().forEach(profileConnection -> activeBattleManagers.put(profileConnection.getWebSocketSession().getId(), battleManager));
        battleManager.ready();
    }

    public void readyForStart(String sessionId) {
        BattleManager battleManager = activeBattleManagers.get(sessionId);
        battleManager.maybeStart(sessionId);
    }

    public void move(String sessionId, String props) {
        BattleManager battleManager = activeBattleManagers.get(sessionId);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Map<String, Object> map = objectMapper.readValue(props, HashMap.class);
            battleManager.move(sessionId, map);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
