package com.mnix.natureofchampions.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tag;
    private String name;
    private Integer level;
    private Integer experience;
    private Integer gold;
    private Integer diamond;
    @OneToMany(mappedBy = "profile", fetch = FetchType.EAGER)
    private List<ProfileCard> cards;

    public Profile(String name) {
        this.tag = UUID.randomUUID().toString();
        this.name = name;
        this.level = 0;
        this.experience = 0;
        this.gold = 0;
        this.diamond = 0;
    }

}
