package com.mnix.natureofchampions.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Card {
    @Id
    private String name;
    private Integer cost;
    private CardRarity rarity;
    private CardType type;

}
