package com.noc.model.entity.collection;

import com.noc.model.constant.card.CardRarity;
import com.noc.model.constant.card.CardType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private CardType type;
    private CardRarity rarity;
    @OneToMany(mappedBy = "card", fetch = FetchType.LAZY)
    private Set<CardStatistic> statistics;

    public Card(String name, CardType type, CardRarity rarity) {
        this.name = name;
        this.type = type;
        this.rarity = rarity;
    }
}
