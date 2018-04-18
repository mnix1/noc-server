package com.noc.database;

import com.google.common.collect.Lists;
import com.noc.model.constant.card.*;
import com.noc.model.entity.collection.*;
import com.noc.model.entity.social.Profile;
import com.noc.repository.collection.*;
import com.noc.repository.social.ProfileRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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
    @Autowired
    DeckCardRepository deckCardRepository;
    @Autowired
    ProfileChampionRepository profileChampionRepository;
    @Autowired
    DeckRepository deckRepository;

    private Random random = new SecureRandom();

    public void initCards() {
        initChampions();
        initCharacterCards();
        initAnimalCards();
        initPlantCards();
        initConstructionCards();
        initSpellCards();
    }

    public void initChampions() {
        Champion champion = new Champion(ChampionName.JOHN_PORTA, ChampionKind.WIZARD, CardType.CHAMPION, CardRarity.RARE);
        championRepository.save(champion);
        List<ChampionStatistic> championStatistics = new ArrayList<>();
        championStatistics.add(new ChampionStatistic(champion, CardProperty.ELIXIR_MAX, "8"));
        championStatistics.add(new ChampionStatistic(champion, CardProperty.ELIXIR_REGENERATION, "1"));
        championStatistics.add(new ChampionStatistic(champion, CardProperty.HEALTH_MAX, "500"));
        championStatistics.add(new ChampionStatistic(champion, CardProperty.HEALTH_REGENERATION, "5"));
        championStatistics.add(new ChampionStatistic(champion, CardProperty.MANA_MAX, "10"));
        championStatistics.add(new ChampionStatistic(champion, CardProperty.MANA_REGENERATION, "2"));
        championStatisticRepository.saveAll(championStatistics);

        champion = new Champion(ChampionName.DAVID_SELL, ChampionKind.TRADER, CardType.CHAMPION, CardRarity.COMMON);
        championRepository.save(champion);
        championStatistics = new ArrayList<>();
        championStatistics.add(new ChampionStatistic(champion, CardProperty.ELIXIR_MAX, "6"));
        championStatistics.add(new ChampionStatistic(champion, CardProperty.ELIXIR_REGENERATION, "2"));
        championStatistics.add(new ChampionStatistic(champion, CardProperty.HEALTH_MAX, "600"));
        championStatistics.add(new ChampionStatistic(champion, CardProperty.HEALTH_REGENERATION, "7"));
        championStatistics.add(new ChampionStatistic(champion, CardProperty.ABILITY_MAX, "8"));
        championStatistics.add(new ChampionStatistic(champion, CardProperty.ABILITY_REGENERATION, "2"));
        championStatisticRepository.saveAll(championStatistics);
    }

    private void createChampionCard(Champion champion, Card card) {
        championCardRepository.save(new ChampionCard(champion, card));
    }

    public void initCharacterCards() {
        CardRarity[] cardRarities = CardRarity.values();
        for (CharacterCardName name : CharacterCardName.values()) {
            Card card = new Card(name.getShortName(), CardType.CHARACTER, cardRarities[random.nextInt(cardRarities.length)]);
            cardRepository.save(card);
            List<CardStatistic> cardStatistics = new ArrayList<>();
            cardStatistics.add(new CardStatistic(card, CardProperty.HEALTH_MAX, (random.nextInt(300) + 40) + ""));
            cardStatistics.add(new CardStatistic(card, CardProperty.HEALTH_REGENERATION, (random.nextInt(4) + 1) + ""));
            cardStatisticRepository.saveAll(cardStatistics);
        }
    }

    public void initAnimalCards() {
        List<Champion> champions = Lists.newArrayList(championRepository.findAll());
        CardRarity[] cardRarities = CardRarity.values();
        for (AnimalCardName name : AnimalCardName.values()) {
            Card card = new Card(name.getShortName(), CardType.ANIMAL, cardRarities[random.nextInt(cardRarities.length)]);
            cardRepository.save(card);
            List<CardStatistic> cardStatistics = new ArrayList<>();
            cardStatistics.add(new CardStatistic(card, CardProperty.HEALTH_MAX, (random.nextInt(100) + 40) + ""));
            cardStatistics.add(new CardStatistic(card, CardProperty.HEALTH_REGENERATION, (random.nextInt(10) + 1) + ""));
            cardStatisticRepository.saveAll(cardStatistics);
            Champion champion = champions.get(random.nextInt(champions.size()));
            createChampionCard(champion, card);
        }
    }

    public void initPlantCards() {
        Champion champion = championRepository.findByNickName(ChampionName.DAVID_SELL.getNickName());
        CardRarity[] cardRarities = CardRarity.values();
        for (PlantCardName name : PlantCardName.values()) {
            Card card = new Card(name.getName(), CardType.PLANT, cardRarities[random.nextInt(cardRarities.length)]);
            cardRepository.save(card);
            List<CardStatistic> cardStatistics = new ArrayList<>();
            cardStatistics.add(new CardStatistic(card, CardProperty.HEALTH_MAX, (random.nextInt(400) + 100) + ""));
            cardStatistics.add(new CardStatistic(card, CardProperty.HEALTH_REGENERATION, (random.nextInt(20) + 1) + ""));
            cardStatisticRepository.saveAll(cardStatistics);
            createChampionCard(champion, card);
        }
    }

    public void initConstructionCards() {
        Champion champion = championRepository.findByNickName(ChampionName.DAVID_SELL.getNickName());
        CardRarity[] cardRarities = CardRarity.values();
        for (ConstructionCardName name : ConstructionCardName.values()) {
            Card card = new Card(name.getName(), CardType.CONSTRUCTION, cardRarities[random.nextInt(cardRarities.length)]);
            cardRepository.save(card);
            List<CardStatistic> cardStatistics = new ArrayList<>();
            cardStatistics.add(new CardStatistic(card, CardProperty.HEALTH_MAX, (random.nextInt(800) + 200) + ""));
            cardStatisticRepository.saveAll(cardStatistics);
            createChampionCard(champion, card);
        }
    }

    public void initSpellCards() {
        Champion champion = championRepository.findByNickName(ChampionName.JOHN_PORTA.getNickName());
        CardRarity[] cardRarities = CardRarity.values();
        for (SpellCardName name : SpellCardName.values()) {
            Card card = new Card(name.getName(), CardType.SPELL, cardRarities[random.nextInt(cardRarities.length)]);
            cardRepository.save(card);
            List<CardStatistic> cardStatistics = new ArrayList<>();
            cardStatistics.add(new CardStatistic(card, CardProperty.DAMAGE, (random.nextInt(100) + 200) + ""));
            cardStatisticRepository.saveAll(cardStatistics);
            createChampionCard(champion, card);
        }
    }

    public void initProfiles() {
        Profile profile = new Profile("t1");
        profileRepository.save(profile);
        initProfileChampions(profile, Stream.of(ChampionName.JOHN_PORTA).collect(Collectors.toList()));
        List<String> cardNames = Stream.of(CharacterCardName.MERCENARY, SpellCardName.FIRE_BALL, AnimalCardName.BEAR, SpellCardName.SNOWBALL,
                SpellCardName.LIGHTING, AnimalCardName.FOX, AnimalCardName.OWL, AnimalCardName.PARROT, CharacterCardName.SCOUT)
                .map(anEnum -> anEnum.getShortName())
                .collect(Collectors.toList());
        initProfileCards(profile, cardNames);
        initDeck(profile, "Test 1");

        profile = new Profile("t2");
        profileRepository.save(profile);
        initProfileChampions(profile, Stream.of(ChampionName.DAVID_SELL).collect(Collectors.toList()));
        cardNames = Stream.of(CharacterCardName.SQUIRE, ConstructionCardName.ELIXIR_GENERATOR, AnimalCardName.OWL, AnimalCardName.FOX,
                AnimalCardName.VULTURE, AnimalCardName.ALLIGATOR, AnimalCardName.DOG, AnimalCardName.PARROT, PlantCardName.JUNIPER, PlantCardName.OAK)
                .map(anEnum -> anEnum.getShortName())
                .collect(Collectors.toList());
        initProfileCards(profile, cardNames);
        initDeck(profile, "Tescik");
    }

    private void initProfileChampions(Profile profile, List<ChampionName> champions) {
        for (ChampionName championName : champions) {
            Champion champion = championRepository.findByNickName(championName.getNickName());
            ProfileChampion profileChampion = new ProfileChampion(random.nextInt(3), random.nextInt(10), profile, champion);
            profileChampionRepository.save(profileChampion);
            profile.getChampions().add(profileChampion);
        }
    }

    private void initProfileCards(Profile profile, List<String> cardNames) {
        for (String cardName : cardNames) {
            Card card = cardRepository.findByName(cardName);
            ProfileCard profileCard = new ProfileCard(random.nextInt(3), random.nextInt(10), profile, card);
            profileCardRepository.save(profileCard);
            profile.getCards().add(profileCard);
        }
    }

    public void initDeck(Profile profile, String name) {
        Champion champion = profile.getChampions().stream()
                .findFirst().get().getChampion();
        Deck deck = new Deck(name, 1, profile, champion);
        deckRepository.save(deck);
        List<Card> cards = profile.getCards().stream()
                .map(profileCard -> profileCard.getCard())
                .collect(Collectors.toList());
        int i = 1;
        for (Card card : cards) {
            DeckCard deckCard = new DeckCard(i++, deck, card);
            deckCardRepository.save(deckCard);
        }
    }
}
