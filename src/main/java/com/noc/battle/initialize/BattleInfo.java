package com.noc.battle.initialize;

import com.noc.model.constant.battle.BattleResult;
import com.noc.model.constant.battle.BattleStatus;
import com.noc.model.entity.social.Profile;
import lombok.Getter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class BattleInfo {
    private List<Profile> profiles = new CopyOnWriteArrayList<Profile>();
    private BattleStatus battleStatus;
    private BattleResult battleResult = BattleResult.EMPTY;

    BattleInfo(Profile profile) {
        profiles.add(profile);
        battleStatus = BattleStatus.SEARCHING_OPPONENT;
    }

    void prepareBattle(Profile profile) {
        profiles.add(profile);
        battleStatus = BattleStatus.PREPARING;
    }

    boolean isSearchingOpponentStatus() {
        return battleStatus == BattleStatus.SEARCHING_OPPONENT;
    }

    boolean isForProfile(Profile profile) {
        return profiles.contains(profile);
    }
}
