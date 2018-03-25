package com.noc.database;

import com.noc.model.Card;
import com.noc.model.CardStatistic;
import com.noc.model.Profile;
import com.noc.model.ProfileCard;
import com.noc.model.constant.card.Rarity;
import com.noc.model.constant.card.Statistic;
import com.noc.model.constant.card.Type;
import com.noc.repository.CardRepository;
import com.noc.repository.CardStatisticRepository;
import com.noc.repository.ProfileCardRepository;
import com.noc.repository.ProfileRepository;
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
        Card wizard = new Card("Wizard", Type.CHARACTER, Rarity.COMMON);
        cardRepository.save(wizard);
        List<CardStatistic> wizardStatistics = new ArrayList<>();
        wizardStatistics.add(new CardStatistic(wizard, Statistic.HEALTH_MAX, "1000"));
        wizardStatistics.add(new CardStatistic(wizard, Statistic.HEALTH_REGENERATION, "10"));
        cardStatisticRepository.saveAll(wizardStatistics);

        Card warrior = new Card("Warrior", Type.CHARACTER, Rarity.RARE);
        cardRepository.save(warrior);
        List<CardStatistic> warriorStatistics = new ArrayList<>();
        warriorStatistics.add(new CardStatistic(warrior, Statistic.HEALTH_MAX, "1000"));
        warriorStatistics.add(new CardStatistic(warrior, Statistic.HEALTH_REGENERATION, "10"));
        cardStatisticRepository.saveAll(warriorStatistics);
    }

    public void initProfiles() {
    }
}
