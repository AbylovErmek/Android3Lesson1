package com.geektech.month5lesson1.ui;

import com.geektech.month5lesson1.domain.Card;
import com.geektech.month5lesson1.domain.Game;

import java.util.ArrayList;
import java.util.List;

public class EmojiGame {

    private Game<String> game;

    public EmojiGame() {
        List<String> contents = new ArrayList<>();
        contents.add("\uD83D\uDE01");
        contents.add("\uD83D\uDE03");
        contents.add("\uD83D\uDE04");
        contents.add("\uD83D\uDE0B");
        contents.add("\uD83D\uDE06");
        game = new Game<>(contents);
    }

    public void choose(Card<String> card){
        game.choose(card);
    }

    public List<Card<String>> getCards(){
        return game.getCards();
    }
}
