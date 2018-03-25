package com.mnix.natureofchampions.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login2")
public class LoginController {

    @GetMapping
    public String test() {
//        Card card = new Card("Wizard", 3, Rarity.COMMON, Type.CHARACTER);
//        cardRepository.save(card);
        return "OK";
    }
}
