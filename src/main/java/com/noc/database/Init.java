package com.noc.database;

import com.noc.model.constant.card.CardProperty;
import com.noc.model.constant.card.CardRarity;
import com.noc.model.constant.card.ChampionKind;
import com.noc.model.entity.collection.Card;
import com.noc.model.entity.collection.CardStatistic;
import com.noc.model.constant.card.CardType;
import com.noc.model.entity.collection.Champion;
import com.noc.model.entity.collection.ChampionStatistic;
import com.noc.repository.collection.*;
import com.noc.repository.social.ProfileRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@NoArgsConstructor
@Service
public class Init {
    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    ProfileCardRepository profileCardRepository;
    @Autowired
    ChampionRepository championRepository;
    @Autowired
    ChampionCardRepository championCardRepository;
    @Autowired
    ChampionStatisticRepository championStatisticRepository;
    @Autowired
    CardRepository cardRepository;
    @Autowired
    CardStatisticRepository cardStatisticRepository;

    public void initCards() {
        initChampions();
        initCharacterCards();
        initAnimalCards();
        initPlantCards();
        initConstructionCards();
        initSpellCards();
    }

    public void initChampions() {
        Champion champion = new Champion("John", "Fire Skater", "Porta", ChampionKind.WIZARD, CardType.CHAMPION, CardRarity.RARE);
        championRepository.save(champion);
        List<ChampionStatistic> championStatistics = new ArrayList<>();
        championStatistics.add(new ChampionStatistic(champion, CardProperty.ELIXIR_MAX, "8"));
        championStatistics.add(new ChampionStatistic(champion, CardProperty.ELIXIR_REGENERATION, "1"));
        championStatistics.add(new ChampionStatistic(champion, CardProperty.HEALTH_MAX, "500"));
        championStatistics.add(new ChampionStatistic(champion, CardProperty.HEALTH_REGENERATION, "5"));
        championStatistics.add(new ChampionStatistic(champion, CardProperty.MANA_MAX, "10"));
        championStatistics.add(new ChampionStatistic(champion, CardProperty.MANA_REGENERATION, "2"));
        championStatisticRepository.saveAll(championStatistics);
    }

    public void initCharacterCards() {
        Random random = new SecureRandom();
        String[] names = new String[]{
                "Squire", "Mercenary", "Scout"
        };
        CardRarity[] cardRarities = CardRarity.values();
        for (String name : names) {
            Card card = new Card(name, CardType.CHARACTER, cardRarities[random.nextInt(cardRarities.length)]);
            cardRepository.save(card);
            List<CardStatistic> cardStatistics = new ArrayList<>();
            cardStatistics.add(new CardStatistic(card, CardProperty.HEALTH_MAX, (random.nextInt(300) + 40) + ""));
            cardStatistics.add(new CardStatistic(card, CardProperty.HEALTH_REGENERATION, (random.nextInt(4) + 1) + ""));
            cardStatisticRepository.saveAll(cardStatistics);
        }
    }

    public void initAnimalCards() {
        Random random = new SecureRandom();
        String[] names = new String[]{
                "Dog", "Cat", "Pigeon", "Horse", "Lion", "Fox", "Bear", "Tiger", "Owl", "Parrot", "Alligator", "Chicken",
                "Rat", "Vulture", "Puma"
        };
        CardRarity[] cardRarities = CardRarity.values();
        for (String name : names) {
            Card card = new Card(name, CardType.ANIMAL, cardRarities[random.nextInt(cardRarities.length)]);
            cardRepository.save(card);
            List<CardStatistic> cardStatistics = new ArrayList<>();
            cardStatistics.add(new CardStatistic(card, CardProperty.HEALTH_MAX, (random.nextInt(100) + 40) + ""));
            cardStatistics.add(new CardStatistic(card, CardProperty.HEALTH_REGENERATION, (random.nextInt(10) + 1) + ""));
            cardStatisticRepository.saveAll(cardStatistics);
        }
    }

    public void initPlantCards() {
        Random random = new SecureRandom();
        String[] names = new String[]{
                "Oak", "Juniper"
        };
        CardRarity[] cardRarities = CardRarity.values();
        for (String name : names) {
            Card card = new Card(name, CardType.ANIMAL, cardRarities[random.nextInt(cardRarities.length)]);
            cardRepository.save(card);
            List<CardStatistic> cardStatistics = new ArrayList<>();
            cardStatistics.add(new CardStatistic(card, CardProperty.HEALTH_MAX, (random.nextInt(400) + 100) + ""));
            cardStatistics.add(new CardStatistic(card, CardProperty.HEALTH_REGENERATION, (random.nextInt(20) + 1) + ""));
            cardStatisticRepository.saveAll(cardStatistics);
        }
    }

    public void initConstructionCards() {
        Random random = new SecureRandom();
        String[] names = new String[]{"Bridge", "Trap", "Elixir Generator", "Power Station"};
        CardRarity[] cardRarities = CardRarity.values();
        for (String name : names) {
            Card card = new Card(name, CardType.CONSTRUCTION, cardRarities[random.nextInt(cardRarities.length)]);
            cardRepository.save(card);
            List<CardStatistic> cardStatistics = new ArrayList<>();
            cardStatistics.add(new CardStatistic(card, CardProperty.HEALTH_MAX, (random.nextInt(800) + 200) + ""));
            cardStatisticRepository.saveAll(cardStatistics);
        }
    }

    public void initSpellCards() {
        Random random = new SecureRandom();
        String[] names = new String[]{"Fire Ball", "Snowball", "Heal", "Resurrection", "Tornado", "Lighting"};
        CardRarity[] cardRarities = CardRarity.values();
        for (String name : names) {
            Card card = new Card(name, CardType.SPELL, cardRarities[random.nextInt(cardRarities.length)]);
            cardRepository.save(card);
            List<CardStatistic> cardStatistics = new ArrayList<>();
            cardStatistics.add(new CardStatistic(card, CardProperty.HEALTH_MAX, (random.nextInt(800) + 200) + ""));
            cardStatisticRepository.saveAll(cardStatistics);
        }
    }

    public void initProfiles() {
    }
}
