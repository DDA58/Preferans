package main.controller;

import main.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StartGame {
    public void setStartGame(Deck deck, Bot bot1, Bot bot2, Bot bot3, Distributor distributor, Distribution distribution) {
        Collections.shuffle(deck.getCards());
        List<Card> cards1 = new ArrayList<>();
        List<Card> cards2 = new ArrayList<>();
        List<Card> cards3 = new ArrayList<>();
        List<Card> cards4 = new ArrayList<>();
        List<Card> cards11 = new ArrayList<>();
        List<Card> cards22= new ArrayList<>();
        List<Card> cards33= new ArrayList<>();
        List<Card> cards44= new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            cards1.add(deck.getCards().get(i));
        }

        bot1.setCards(cards1);
        cards11.addAll(cards1);
        distribution.setCrdbot1(cards11);

        for (int j = 10; j < 20; j++) {
            cards2.add(deck.getCards().get(j));
        }
        bot2.setCards(cards2);
        cards22.addAll(cards2);
        distribution.setCrdbot2(cards22);

        for (int k = 20; k < 30; k++) {
            cards3.add(deck.getCards().get(k));
        }
        bot3.setCards(cards3);
        cards33.addAll(cards3);
        distribution.setCrdbot3(cards33);

        for (int n = 30; n < 32; n++) {
            cards4.add(deck.getCards().get(n));
        }
        distributor.setCards(cards4);
        cards44.addAll(cards4);
        distribution.setCrddistr(cards44);
    }
}
