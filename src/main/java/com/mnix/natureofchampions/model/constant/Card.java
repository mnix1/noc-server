package com.mnix.natureofchampions.model.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Card {
    WIZARD("Wizard", 2, CardType.CHARACTER, CardRarity.COMMON),
    WARRIOR("Warrior", 3, CardType.CHARACTER, CardRarity.COMMON);


    private String name;
    private Integer cost;
    private CardType type;
    private CardRarity rarity;

}
