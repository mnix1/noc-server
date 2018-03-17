package com.mnix.natureofchampions.model;

import com.mnix.natureofchampions.model.constant.Card;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProfileCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false, updatable = false)
    private Profile profile;
    private Card card;
    private Integer level = 0;
    private Integer quantity = 0;

    public ProfileCard(Profile profile, Card card) {
        this.profile = profile;
        this.card = card;
    }

}
