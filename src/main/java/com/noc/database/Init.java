package com.noc.database;

import com.noc.model.constant.card.CardProperty;
import com.noc.model.constant.card.CardRarity;
import com.noc.model.entity.collection.Card;
import com.noc.model.entity.collection.CardStatistic;
import com.noc.model.constant.card.CardType;
import com.noc.repository.collection.CardRepository;
import com.noc.repository.collection.CardStatisticRepository;
import com.noc.repository.collection.ProfileCardRepository;
import com.noc.repository.social.ProfileRepository;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
public class Init {

    ProfileRepository profileRepository;
    ProfileCardRepository profileCardRepository;
    CardRepository cardRepository;
    CardStatisticRepository cardStatisticRepository;

    public void initCards(){
        Card wizard = new Card("Wizard", CardType.CHARACTER, CardRarity.COMMON);
        cardRepository.save(wizard);
        List<CardStatistic> wizardStatistics = new ArrayList<>();
        wizardStatistics.add(new CardStatistic(wizard, CardProperty.HEALTH_MAX, "1000"));
        wizardStatistics.add(new CardStatistic(wizard, CardProperty.HEALTH_REGENERATION, "10"));
        cardStatisticRepository.saveAll(wizardStatistics);

        Card warrior = new Card("Warrior", CardType.CHARACTER, CardRarity.RARE);
        cardRepository.save(warrior);
        List<CardStatistic> warriorStatistics = new ArrayList<>();
        warriorStatistics.add(new CardStatistic(warrior, CardProperty.HEALTH_MAX, "1000"));
        warriorStatistics.add(new CardStatistic(warrior, CardProperty.HEALTH_REGENERATION, "10"));
        cardStatisticRepository.saveAll(warriorStatistics);
    }

    public void initProfiles() {
    }
}
