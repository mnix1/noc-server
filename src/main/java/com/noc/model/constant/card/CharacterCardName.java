package com.noc.model.constant.card;

import lombok.Getter;

@Getter
public enum CharacterCardName implements ShortNameable {

    SQUIRE("Squire"),
    MERCENARY("Mercenary"),
    SCOUT("Scout");

    private String name;

    CharacterCardName(String name) {
        this.name = name;
    }

    @Override
    public String getShortName() {
        return getName();
    }
}
