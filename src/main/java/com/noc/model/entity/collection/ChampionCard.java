package com.noc.model.entity.collection;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class ChampionCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "champion_id", nullable = false, updatable = false)
    private Champion champion;
    @ManyToOne
    @JoinColumn(name = "card_id", nullable = false, updatable = false)
    private Card card;

    public ChampionCard(Champion champion, Card card) {
        this.champion = champion;
        this.card = card;
    }
}
