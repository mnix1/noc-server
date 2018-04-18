package com.noc.model.entity.collection;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class DeckCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer position;
    @ManyToOne
    @JoinColumn(name = "deck_id", nullable = false, updatable = false)
    private Deck deck;
    @ManyToOne
    @JoinColumn(name = "card_id", nullable = false, updatable = false)
    private Card card;

    public DeckCard(Integer position, Deck deck, Card card) {
        this.position = position;
        this.deck = deck;
        this.card = card;
    }
}
