package com.noc.model.constant.card;

import lombok.Getter;

@Getter
public enum ConstructionCardName implements ShortNameable {

    BRIDGE("Bridge"),
    POWER_STATION("Power Station"),
    ELIXIR_GENERATOR("Elixir Generator");

    private String name;

    ConstructionCardName(String name) {
        this.name = name;
    }

    @Override
    public String getShortName() {
        return getName();
    }
}
