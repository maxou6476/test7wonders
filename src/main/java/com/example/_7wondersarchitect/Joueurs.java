package com.example._7wondersarchitect;

import java.util.ArrayList;

public class Joueurs {
    private String name;
    private Deck deck;
    private Wonders wonders;


    public void createJoueurs(String name, Wonders wonders, Deck deck) {
        this.name = name;
        this.wonders = wonders;
        this.deck = new Deck();
    }

    public String getName() {

        return name;
    }

}
