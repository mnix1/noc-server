package com.noc.battle;

import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlayerManager {
    private static final Logger logger = LoggerFactory.getLogger(PlayerManager.class);
    private final BattleManager battleManager;

    public PlayerManager(BattleManager battleManager) {
        this.battleManager = battleManager;
    }

    public void playerChannelInitialized(Channel channel) {
        // TODO for now wrong team init
        int playersSize = battleManager.getPlayers().size();
        battleManager.addPlayer(new Player(channel, playersSize));
        playersSize++;
        logger.info("Player added, playersSize: " + playersSize);
        if (playersSize == 2) {
            battleManager.startGame();
        }
    }
}
