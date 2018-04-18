package com.noc.model.entity.collection;

import com.noc.model.entity.social.Profile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Deck {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer position;
    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false, updatable = false)
    private Profile profile;
    @ManyToOne
    @JoinColumn(name = "champion_id", updatable = false)
    private Champion champion;
    @OneToMany(mappedBy = "deck", fetch = FetchType.LAZY)
    private Set<DeckCard> cards;

    public Deck(String name, Integer position, Profile profile, Champion champion) {
        this.name = name;
        this.position = position;
        this.profile = profile;
        this.champion = champion;
    }
}
