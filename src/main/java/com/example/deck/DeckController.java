package com.example.deck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("/api/deck")

public class DeckController {
    private final DeckService deckService;
    @Autowired
    public DeckController(DeckService deckService) {
        this.deckService = deckService;
    }
    @GetMapping("getDeck")
    public List<Card> getDeck() {
        return new ArrayList<>(deckService.getDeck().values());
    }
}
