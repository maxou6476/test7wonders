package com.example._7wondersarchitect;

import java.util.ArrayList;

public class Joueurs {
    private String name;
    private Deck deck;
    private Wonders wonders;

    private ArrayList<Cartes> Hand;


    public void createJoueurs(String name, Wonders wonders, Deck deck) {
        this.name = name;
        this.wonders = wonders;
        this.deck = deck;
        this.Hand = new ArrayList<Cartes>();
    }

    public String getName() {
        return name;
    }

    public Deck getDeck(){
        return deck;
    }

    public void addCard(Cartes card) {
        Hand.add(card);
    }

    public ArrayList<Cartes> showcard(){
        return Hand;
    }
    public int handSize() {

        return Hand.size();
    }

}