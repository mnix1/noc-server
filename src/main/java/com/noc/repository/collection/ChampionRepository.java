package com.noc.repository.collection;

import com.noc.model.entity.collection.Champion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionRepository extends CrudRepository<Champion, Long> {
    Champion findByNickName(String nickName);
}
