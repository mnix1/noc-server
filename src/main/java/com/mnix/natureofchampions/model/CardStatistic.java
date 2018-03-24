package com.mnix.natureofchampions.model;

import com.mnix.natureofchampions.model.constant.card.Statistic;
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
    @ManyToOne
    @JoinColumn(name = "card_id", nullable = false, updatable = false)
    private Card card;
    private Statistic statistic;
    private String value;

    public CardStatistic(Card card, Statistic statistic, String value) {
        this.card = card;
        this.statistic = statistic;
        this.value = value;
    }
}
