package com.noc.model.entity.social;

import com.noc.helper.TagHelper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tag;
    private String name;
    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private Set<TeamProfile> profiles;

    public Team(String name) {
        this.tag = TagHelper.randomTag();
        this.name = name;
    }
}
