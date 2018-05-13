package com.noc.battle;

import com.noc.service.social.ProfileService;
import com.noc.websocket.ProfileConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class BattleService {
    private CopyOnWriteArrayList<BattleWrapper> activeBattles = new CopyOnWriteArrayList<BattleWrapper>();

    @Autowired
    private ProfileService profileService;

    public BattleWrapper createBattle(ProfileConnection profileConnection) {
        Optional<BattleWrapper> battleInfoOptional = activeBattles.stream()
                .filter(BattleWrapper::isSearchingOpponentStatus)
                .findFirst();
        if (battleInfoOptional.isPresent()) {
            BattleWrapper battleWrapper = battleInfoOptional.get();
            battleWrapper.prepareBattle(profileConnection);
            return battleWrapper;
        }
        BattleWrapper battleWrapper = new BattleWrapper(profileConnection);
        activeBattles.add(battleWrapper);
        return battleWrapper;
    }

    public void cancelBattle(final ProfileConnection profileConnection) {
        activeBattles.removeIf(battleWrapper -> battleWrapper.isForProfile(profileConnection));
    }

    public void prepareBattle(BattleWrapper battleWrapper) {
        battleWrapper.sendMessage("BATTLE_PREPARING");
        battleWrapper.updateProfileConnections(profileService);
        BattleManager battleManager = new BattleManager(battleWrapper);
        battleWrapper.sendMessage("BATTLE_IN_PROGRESS");
        battleManager.start();
    }


}
