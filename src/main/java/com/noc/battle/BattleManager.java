package com.noc.battle;

import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BattleManager {
    private static final Logger logger = LoggerFactory.getLogger(BattleManager.class);
    private final List<Player> players = new ArrayList<Player>();

    public void startGame() {
        logger.info("Start Game");
        Flowable.interval(1000, TimeUnit.MILLISECONDS)
                .subscribe(aLong -> {
                    players.forEach(player -> player.send("SIEMA"));
                });
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public PlayerManager getGamePlayerManager() {
        return new PlayerManager(this);
    }
}
