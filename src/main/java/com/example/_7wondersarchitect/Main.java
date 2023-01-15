package com.example._7wondersarchitect;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        jinx_aff jinxAff = new jinx_aff();
        jinxAff.jinx_launch();



        ArrayList<Object> Deck = new ArrayList<>();
        ArrayList<Object> Jetons = new ArrayList<>();

        Cartes Bois = new Cartes_Grises("Bois");
        Cartes Brique = new Cartes_Grises("Brique");
        Cartes Fer = new Cartes_Grises("Fer");
        Cartes Verre = new Cartes_Grises("Verre");
        Cartes Parchemin = new Cartes_Grises("Parchemin");

        Cartes Or = new Cartes_Jaunes("Or");

        Cartes Point = new Cartes_Bleues("Point de victoire");
        Cartes Point_Chat = new Cartes_Bleues("Point de victoire avec le pion chat");

        Cartes Engrenage = new Cartes_Vertes("Engrenage");
        Cartes Compas = new Cartes_Vertes("Compas");
        Cartes Tablette = new Cartes_Vertes("Tablette");

        Cartes Bouclier = new Cartes_Rouges("Bouclier");
        Cartes Bouclier_corne1 = new Cartes_Rouges("Bouclier avec 1 corne");
        Cartes Bouclier_corne2 = new Cartes_Rouges("Bouclier avec 2 cornes");

        Jetons Conflit = new Jeton_Conflit("Jeton de conflit");
        Jetons Progres = new Jeton_Progres("Jeton de progres");
        Jetons Victoire_militaire = new Jeton_Victoir_Militaire("Jeton de victoire militaire");

        

    }
}