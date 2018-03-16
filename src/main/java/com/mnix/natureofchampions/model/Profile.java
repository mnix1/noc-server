package com.mnix.natureofchampions.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Profile {
    @Id
    private String tag;
    private String name;
    private Integer level;
    private Integer gold;
    private Integer diamond;

    public Profile(String name) {
        this.tag = UUID.randomUUID().toString();
        this.name = name;
        this.level = 0;
        this.gold = 0;
        this.diamond = 0;
    }

}
