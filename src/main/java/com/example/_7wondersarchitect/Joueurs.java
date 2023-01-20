package com.example._7wondersarchitect;

import java.util.ArrayList;

public class Joueurs {
    private String name;
    private ArrayList<Cartes> hand;


    public Joueurs(String name) {
        this.name = name;
        this.hand = new ArrayList<Cartes>();

    }

    public void drawCard(Deck deck) {
        Cartes card = deck.drawCard();
        if (card != null) {
            hand.add(card);
        }
    }

    public void playCard(Cartes card) {
        if (hand.contains(card)) {
            hand.remove(card);
            //Implement the effect of the card here
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Cartes> getHand() {
        return hand;
    }

}
