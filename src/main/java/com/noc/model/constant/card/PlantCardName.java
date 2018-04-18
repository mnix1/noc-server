package com.noc.model.constant.card;

import lombok.Getter;

@Getter
public enum PlantCardName implements ShortNameable {

    OAK("Oak"),
    JUNIPER("Juniper");

    private String name;

    PlantCardName(String name) {
        this.name = name;
    }

    @Override
    public String getShortName() {
        return getName();
    }
}
