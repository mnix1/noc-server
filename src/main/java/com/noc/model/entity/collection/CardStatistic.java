package com.noc.model.entity.collection;

import com.noc.model.constant.card.CardProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class CardStatistic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private CardProperty property;
    private String value;
    @ManyToOne
    @JoinColumn(name = "card_id", nullable = false, updatable = false)
    private Card card;

    public CardStatistic(Card card, CardProperty property, String value) {
        this.card = card;
        this.property = property;
        this.value = value;
    }
}
