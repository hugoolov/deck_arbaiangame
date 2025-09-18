package com.example.deck;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class DeckService {

    public List<Card> loadCardsFromJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("cards.json")) {
            if (is == null) {
                throw new RuntimeException("cards.json not found in resources folder!");
            }
            return objectMapper.readValue(is, new TypeReference<List<Card>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Failed to load cards.json", e);
        }
    }
    public LinkedHashMap<Long, Card> getDeck() {
        LinkedHashMap<Long, Card> shuffeldeDeck = new LinkedHashMap<>();
        List<Card> cards = loadCardsFromJson();
        Collections.shuffle(cards);
        long key = 1L;
        for (Card card : cards) {
            shuffeldeDeck.put(key++, card);
        }
        return shuffeldeDeck;
    }
}
