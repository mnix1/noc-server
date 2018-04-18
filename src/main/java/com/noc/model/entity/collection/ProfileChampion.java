package com.noc.model.entity.collection;

import com.noc.model.entity.social.Profile;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProfileChampion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer level = 0;
    private Integer quantity = 0;
    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false, updatable = false)
    private Profile profile;
    @ManyToOne
    @JoinColumn(name = "champion_id", nullable = false, updatable = false)
    private Champion champion;

    public ProfileChampion(Profile profile, Champion champion) {
        this.profile = profile;
        this.champion = champion;
    }

    public ProfileChampion(Integer level, Integer quantity, Profile profile, Champion champion) {
        this.level = level;
        this.quantity = quantity;
        this.profile = profile;
        this.champion = champion;
    }
}
