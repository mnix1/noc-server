package com.mnix.natureofchampions.database;

import com.mnix.natureofchampions.model.Card;
import com.mnix.natureofchampions.model.CardStatistic;
import com.mnix.natureofchampions.model.Profile;
import com.mnix.natureofchampions.model.ProfileCard;
import com.mnix.natureofchampions.model.constant.card.Rarity;
import com.mnix.natureofchampions.model.constant.card.Statistic;
import com.mnix.natureofchampions.model.constant.card.Type;
import com.mnix.natureofchampions.repository.CardRepository;
import com.mnix.natureofchampions.repository.CardStatisticRepository;
import com.mnix.natureofchampions.repository.ProfileCardRepository;
import com.mnix.natureofchampions.repository.ProfileRepository;
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
        Profile mnix = new Profile("MNIX");
        profileRepository.save(mnix);
        List<ProfileCard>  mnixCards = new ArrayList<>();
        mnixCards.add(new ProfileCard(mnix, cardRepository.findByName("Wizard")));
        profileCardRepository.saveAll(mnixCards);
    }
}
