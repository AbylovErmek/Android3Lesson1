package com.geektech.month5lesson1.domain;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game<Content> {

    private List<Card<Content>> cards = new ArrayList<>();

    public Game(List<Content> contents) {
        for (int i = 0; i < contents.size(); i++) {
            cards.add(new Card<>(i * 2, false, false, contents.get(i)));
            cards.add(new Card<>((i * 2) + 1, false, false, contents.get(i)));
        }
        Collections.shuffle(cards);
    }

    public void choose(Card<Content> card) {
        card.setFaceUp(!card.isFaceUp());
        checkPairs(card);
    }

    private void checkPairs(Card<Content> card) {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).isFaceUp()
                    && cards.get(i).getContent().equals(card.getContent())
                    && cards.get(i).getId() != card.getId()) {
                card.setMatch(true);
                cards.get(i).setMatch(true);
            } else if (cards.get(i).getId() != card.getId()
                    && cards.get(i).isFaceUp()
                    && !card.getContent().equals(cards.get(i).getContent())) {
                cards.get(i).setFaceUp(false);
                Log.d("TAG", "checkPairs: MATCH");
            }
        }
    }

    public List<Card<Content>> getCards() {
        return cards;
    }
}
