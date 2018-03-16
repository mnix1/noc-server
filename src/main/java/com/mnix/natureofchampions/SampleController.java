package com.mnix.natureofchampions;

import com.mnix.natureofchampions.model.Card;
import com.mnix.natureofchampions.model.CardRarity;
import com.mnix.natureofchampions.model.CardType;
import com.mnix.natureofchampions.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("test")
public class SampleController {

    @Autowired
    private CardRepository cardRepository;

    @GetMapping
    public String test() {
        Card card = new Card("Wizard", 3, CardRarity.COMMON, CardType.CHARACTER);
        cardRepository.save(card);
        return "OK";
    }
}
