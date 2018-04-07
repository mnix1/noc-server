package com.noc.model.entity.social;

import com.noc.helper.TagHelper;
import com.noc.model.entity.collection.Deck;
import com.noc.model.entity.collection.ProfileCard;
import com.noc.model.entity.battle.ProfileLadder1Vs1Battle;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String authId;
    private String tag;
    private String name;
    private Integer level;
    private Integer experience;
    private Integer gold;
    private Integer diamond;
    private Integer ladder1Vs1BattleElo;
    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private Set<TeamProfile> teams;
    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private Set<ProfileLadder1Vs1Battle> ladder1Vs1Battles;
    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private Set<ProfileCard> cards;
    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private Set<Deck> decks;

    public Profile(String authId) {
        this.tag = TagHelper.randomTag();
        this.authId = authId;
        this.level = 0;
        this.experience = 0;
        this.gold = 0;
        this.diamond = 0;
        this.ladder1Vs1BattleElo = 0;
        this.ladder1Vs1Battles = new HashSet<>();
        this.cards = new HashSet<>();
        this.decks = new HashSet<>();
        this.teams = new HashSet<>();
    }

}
