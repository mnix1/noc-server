package com.noc.model.constant.card;

import lombok.Getter;

@Getter
public enum ChampionName implements ShortNameable {

    JOHN_PORTA("John", "Fire Skater", "Porta"),
    DAVID_SELL("David", "Big Pouch", "Sell");

    private String firstName;
    private String nickName;
    private String lastName;

    ChampionName(String firstName, String nickName, String lastName) {
        this.firstName = firstName;
        this.nickName = nickName;
        this.lastName = lastName;
    }

    @Override
    public String getShortName() {
        if (nickName != null) {
            return getNickName();
        }
        return getFirstName() + " " + getLastName();
    }
}
