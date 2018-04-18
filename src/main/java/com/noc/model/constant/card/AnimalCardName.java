package com.noc.model.constant.card;

import lombok.Getter;

@Getter
public enum AnimalCardName implements ShortNameable {

    DOG("Dog"),
    CAT("Cat"),
    HORSE("Horse"),
    LION("Lion"),
    FOX("Fox"),
    BEAR("Bear"),
    TIGER("Tiger"),
    OWL("Owl"),
    PARROT("Parrot"),
    ALLIGATOR("Alligator"),
    CHICKEN("Chicken"),
    RAT("Rat"),
    VULTURE("Vulture"),
    PUMA("Puma"),
    PIGEON("Pigeon");

    private String name;

    AnimalCardName(String name) {
        this.name = name;
    }

    @Override
    public String getShortName() {
        return getName();
    }
}
