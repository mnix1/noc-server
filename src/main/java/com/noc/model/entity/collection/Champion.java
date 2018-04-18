package com.noc.model.entity.collection;

import com.noc.model.constant.card.CardRarity;
import com.noc.model.constant.card.CardType;
import com.noc.model.constant.card.ChampionKind;
import com.noc.model.constant.card.ChampionName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Champion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String nickName;
    private String lastName;
    private ChampionKind kind;
    private CardType type;
    private CardRarity rarity;
    @OneToMany(mappedBy = "champion", fetch = FetchType.LAZY)
    private Set<ChampionStatistic> statistics;
    @OneToMany(mappedBy = "champion", fetch = FetchType.LAZY)
    private Set<ChampionCard> cards;

    public Champion(String firstName, String nickName, String lastName, ChampionKind kind, CardType type, CardRarity rarity) {
        this.firstName = firstName;
        this.nickName = nickName;
        this.lastName = lastName;
        this.kind = kind;
        this.type = type;
        this.rarity = rarity;
    }

    public Champion(ChampionName name, ChampionKind kind, CardType type, CardRarity rarity) {
        this.firstName = name.getFirstName();
        this.nickName = name.getNickName();
        this.lastName = name.getLastName();
        this.kind = kind;
        this.type = type;
        this.rarity = rarity;
    }
}
