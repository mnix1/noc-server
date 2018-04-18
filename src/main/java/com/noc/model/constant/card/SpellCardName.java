package com.noc.model.constant.card;

import lombok.Getter;

@Getter
public enum SpellCardName implements ShortNameable {

    FIRE_BALL("Fire Ball"),
    SNOWBALL("Snowball"),
    RESURRECTION("Resurrection"),
    TORNADO("Tornado"),
    LIGHTING("Lighting"),
    HEAL("Heal");

    private String name;

    SpellCardName(String name) {
        this.name = name;
    }

    @Override
    public String getShortName() {
        return getName();
    }
}
