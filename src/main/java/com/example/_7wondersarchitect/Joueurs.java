package com.example._7wondersarchitect;

import java.util.ArrayList;
import java.util.List;

public class Joueurs {
    List<Cartes> cartejoueur = new ArrayList<Cartes>();
    List<Jetons> jetonsjoueur = new ArrayList<Jetons>();
    Wonders wonder;
    String nom;

    public Joueurs(String nom){
        this.nom = nom;
    }

    void getCarte(Cartes carte){
        cartejoueur.add(carte);
    }

    void getWonder(Wonders w){
        wonder = w;
    }

    void affichecartes(){
        System.out.print("[");
        for(int i = 0; i < cartejoueur.size(); i++){
            if(i == cartejoueur.size()-1) {
                System.out.print(cartejoueur.get(i).nom);
            }else{
                System.out.print(cartejoueur.get(i).nom+",");
            }
        }
        System.out.println("]");
    }

    void affichejetons(){
        System.out.print("[");
        for(int i = 0; i < jetonsjoueur.size(); i++){
            if(i == jetonsjoueur.size()-1) {
                System.out.print(jetonsjoueur.get(i).nom);
            }else{
                System.out.print(jetonsjoueur.get(i).nom+",");
            }
        }
        System.out.println("]");
    }
}
