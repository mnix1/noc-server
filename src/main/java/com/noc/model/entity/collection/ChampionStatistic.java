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
public class ChampionStatistic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private CardProperty property;
    private String value;
    @ManyToOne
    @JoinColumn(name = "champion_id", nullable = false, updatable = false)
    private Champion champion;

    public ChampionStatistic(Champion champion, CardProperty property, String value) {
        this.champion = champion;
        this.property = property;
        this.value = value;
    }
}
