package com.noc.service.battle;

import com.noc.model.constant.battle.BattleSide;
import com.noc.model.constant.battle.BattleStatus;
import com.noc.model.entity.battle.Ladder1Vs1Battle;
import com.noc.model.entity.social.Profile;
import com.noc.model.entity.battle.ProfileLadder1Vs1Battle;
import com.noc.repository.battle.Ladder1Vs1BattleRepository;
import com.noc.repository.battle.ProfileLadder1Vs1BattleRepository;
import com.noc.repository.social.ProfileRepository;
import com.noc.service.SessionService;
import com.noc.service.social.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Ladder1Vs1BattleService {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private Ladder1Vs1BattleRepository ladder1Vs1BattleRepository;

    @Autowired
    private ProfileLadder1Vs1BattleRepository profileLadder1Vs1BattleRepository;

    public static  final Integer FIND_LADDER_BATTLE_ELO_DIFFERENCE_LIMIT = 100;

    public void cancelLadder1Vs1Battle() {
        final Profile profile = profileService.getProfile();
        // search for existing entity lookups
        List<ProfileLadder1Vs1Battle> profileLadder1Vs1Battles = profileLadder1Vs1BattleRepository.findAllByProfileAndLadder1Vs1Battle_Status(profile, BattleStatus.SEARCHING_OPPONENT);
        if (profileLadder1Vs1Battles.isEmpty()) {
            return;
        }
        profileLadder1Vs1BattleRepository.deleteAll(profileLadder1Vs1Battles);
    }

    public Ladder1Vs1Battle prepareLadder1Vs1Battle() throws IllegalAccessException {
        final Profile profile = profileService.getProfile();
        // search for existing entity lookups
        List<ProfileLadder1Vs1Battle> profileLadder1Vs1Battles = profileLadder1Vs1BattleRepository.findAllByProfileAndLadder1Vs1Battle_Status(profile, BattleStatus.SEARCHING_OPPONENT);
        if (profileLadder1Vs1Battles.isEmpty()) {
            // create new ladder entity or join to existing
            Ladder1Vs1Battle ladder1Vs1Battle = findLadderBattle(profile).orElseGet(() -> createLadderBattle(profile));
            return ladder1Vs1Battle;
        } else if (profileLadder1Vs1Battles.size() > 1) {
            throw new IllegalAccessException("More than one existing profile ladder entity. HACKER!");
        }
        return profileLadder1Vs1Battles.get(0).getLadder1Vs1Battle();
    }

    private Optional<Ladder1Vs1Battle> findLadderBattle(Profile profile) {
        List<ProfileLadder1Vs1Battle> profileLadder1Vs1Battles = profileLadder1Vs1BattleRepository.findAllByLadder1Vs1Battle_StatusAndProfile_Ladder1Vs1BattleEloBetweenOrderByProfile_Ladder1Vs1BattleElo(BattleStatus.SEARCHING_OPPONENT, profile.getLadder1Vs1BattleElo() - FIND_LADDER_BATTLE_ELO_DIFFERENCE_LIMIT, profile.getLadder1Vs1BattleElo() + FIND_LADDER_BATTLE_ELO_DIFFERENCE_LIMIT);
        if (profileLadder1Vs1Battles.isEmpty()) {
            return Optional.empty();
        }
        int index = (int) Math.floor(profileLadder1Vs1Battles.size() / 2);
        Ladder1Vs1Battle ladder1Vs1Battle = profileLadder1Vs1Battles.get(index).getLadder1Vs1Battle();
        // team1 for joining
        createProfileLadder1Vs1Battle(BattleSide.BATTLE_SIDE_1, profile, ladder1Vs1Battle);
        ladder1Vs1Battle.setStatus(BattleStatus.PREPARING);
        ladder1Vs1BattleRepository.save(ladder1Vs1Battle);
        return Optional.of(ladder1Vs1Battle);
    }

    private Ladder1Vs1Battle createLadderBattle(Profile profile) {
        Ladder1Vs1Battle ladder1Vs1Battle = new Ladder1Vs1Battle();
        ladder1Vs1BattleRepository.save(ladder1Vs1Battle);
        // team0 for creating
        createProfileLadder1Vs1Battle(BattleSide.BATTLE_SIDE_0, profile, ladder1Vs1Battle);
        return ladder1Vs1Battle;
    }

    private ProfileLadder1Vs1Battle createProfileLadder1Vs1Battle(BattleSide battleSide, Profile profile, Ladder1Vs1Battle ladder1Vs1Battle){
        ProfileLadder1Vs1Battle profileLadder1Vs1Battle = new ProfileLadder1Vs1Battle(battleSide, profile, ladder1Vs1Battle);
        profileLadder1Vs1BattleRepository.save(profileLadder1Vs1Battle);
        return profileLadder1Vs1Battle;
    }
}
