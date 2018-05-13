package com.noc.battle;

import com.noc.model.constant.battle.BattleResult;
import com.noc.model.constant.battle.BattleStatus;
import com.noc.service.social.ProfileService;
import com.noc.websocket.ProfileConnection;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.socket.TextMessage;

import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
@Getter
@Setter
public class BattleWrapper {

    private List<ProfileConnection> profileConnections = new CopyOnWriteArrayList<ProfileConnection>();
    private BattleStatus battleStatus;
    private BattleResult battleResult = BattleResult.EMPTY;

    public BattleWrapper(ProfileConnection profile) {
        profileConnections.add(profile);
        battleStatus = BattleStatus.SEARCHING_OPPONENT;
    }

    public void prepareBattle(ProfileConnection profile) {
        profileConnections.add(profile);
        battleStatus = BattleStatus.PREPARING;
    }

    public boolean isSearchingOpponentStatus() {
        return battleStatus == BattleStatus.SEARCHING_OPPONENT;
    }

    public boolean isPreparingStatus() {
        return battleStatus == BattleStatus.PREPARING;
    }

    public boolean isForProfile(ProfileConnection profile) {
        return profileConnections.contains(profile);
    }

    public void updateProfileConnections(ProfileService profileService) {
        profileConnections.forEach(profileConnection -> profileConnection.setProfile(profileService.getProfile(profileConnection.getProfileId())));
    }

    public int profileConnected(){
        return profileConnections.size();
    }

    public void sendMessage(String message) {
        profileConnections.forEach(profileConnection -> {
            try {
                profileConnection.getWebSocketSession().sendMessage(new TextMessage(message));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void sendMessage(String message, int profileIndex) {
        try {
            profileConnections.get(profileIndex).getWebSocketSession().sendMessage(new TextMessage(message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
