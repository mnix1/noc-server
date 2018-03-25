package com.noc.model;

import com.noc.model.constant.card.Rarity;
import com.noc.model.constant.card.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Type type;
    private Rarity rarity;
    @OneToMany(mappedBy = "card", fetch = FetchType.EAGER)
    private List<CardStatistic> statistics;

    public Card(String name, Type type, Rarity rarity) {
        this.name = name;
        this.type = type;
        this.rarity = rarity;
    }
}
