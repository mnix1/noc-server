package com.noc.battle.initialize;

import com.noc.model.entity.social.Profile;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class BattleService {
    private CopyOnWriteArrayList<BattleInfo> activeBattles = new CopyOnWriteArrayList<BattleInfo>();

    public BattleInfo prepareBattle(Profile profile) {
        Optional<BattleInfo> battleInfoOptional = activeBattles.stream()
                .filter(BattleInfo::isSearchingOpponentStatus)
                .findFirst();
        if (battleInfoOptional.isPresent()) {
            BattleInfo battleInfo = battleInfoOptional.get();
            battleInfo.prepareBattle(profile);
            return battleInfo;
        }
        BattleInfo battleInfo = new BattleInfo(profile);
        activeBattles.add(battleInfo);
        Date createBattleDate = new Date();
        while (activeBattles.contains(battleInfo) && battleInfo.isSearchingOpponentStatus() && !processTakeTooLongTime(createBattleDate)) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return battleInfo;
    }

    private boolean processTakeTooLongTime(Date createBattleDate) throws IllegalStateException {
        if (new Date().getTime() - createBattleDate.getTime() > 10000) {
            throw new IllegalStateException("Zbyt długo");
        }
        return false;
    }

    public void cancelBattle(final Profile profile) {
        activeBattles.stream()
                .filter(battleInfo -> battleInfo.isForProfile(profile))
                .findFirst()
                .ifPresent(battleInfo -> activeBattles.remove(battleInfo));
    }

}
