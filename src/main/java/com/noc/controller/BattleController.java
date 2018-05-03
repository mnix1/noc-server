package com.noc.controller;

import com.noc.battle.initialize.BattleInfo;
import com.noc.battle.initialize.BattleService;
import com.noc.model.entity.social.Profile;
import com.noc.service.SessionService;
import com.noc.service.social.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class BattleController {

    @Autowired
    BattleService battleService;

    @Autowired
    SessionService sessionService;

    @Autowired
    ProfileService profileService;

    @RequestMapping(value = "/startBattle", method = RequestMethod.GET)
    public Map startBattle() {
        Map<String, Object> model = new HashMap<>();
        BattleInfo battleInfo = battleService.prepareBattle(profileService.getProfile());

        return model;
    }

    @RequestMapping(value = "/cancelBattle", method = RequestMethod.GET)
    public Map cancelBattle() {
        Map<String, Object> model = new HashMap<>();
        battleService.cancelBattle(profileService.getProfile());
        return model;
    }
}
