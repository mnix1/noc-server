package com.mnix.natureofchampions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("test")
public class SampleController {

    @GetMapping
    public String test() {
//        Card card = new Card("Wizard", 3, CardRarity.COMMON, CardType.CHARACTER);
//        cardRepository.save(card);
        return "OK";
    }
}
