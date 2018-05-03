package com.noc.battle;

import com.noc.model.entity.social.Profile;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

public class Player {
    private final Channel channel;
    private final int team;
    private Profile profile;

    public Player(Channel channel, int team) {
        this.channel = channel;
        this.team = team;
    }

    public void send(String message) {
        channel.writeAndFlush(new TextWebSocketFrame(message));
    }
}
