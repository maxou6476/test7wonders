package com.example._7wondersarchitect;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Cartes> cards;

    public Deck() {
        cards = new ArrayList<Cartes>();
    }

    public void addCard(Cartes card) {

        cards.add(card);
    }

    public Cartes drawCard() {
        if (cards.size() > 0) {
            return cards.remove(0);
        } else {
            return null;
        }
    }
    public ArrayList<Cartes> getDeck() {
        return cards;
    }
    public void shuffle() {
        Collections.shuffle(cards);
    }

    public int getNumberOfCards() {

        return cards.size();
    }
}