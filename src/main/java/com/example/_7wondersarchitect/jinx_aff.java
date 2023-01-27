package com.example._7wondersarchitect;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class jinx_aff extends Application
{
    public static Stage jinxstage;
    private static FXMLLoader loader;

    public void jinx_launch(){
        launch();
    }
    @Override
    public void start(Stage stage) throws IOException
    {
        jinx_aff.setStage(stage);
        jinx_aff.loadFXMLScene("hello-view.fxml");
    }

    public static void setStage(Stage stage)
    {
        jinxstage = stage;
    }

    public static void loadFXMLScene(String path) throws IOException
    {
        // Create a new FXMLLoader object
        loader = new FXMLLoader(Main.class.getResource(path));
        // Load the FXML file
        Parent root = loader.load();
        // Set the root node of the scene to the newly loaded FXML file
        Scene scene = new Scene(root);
        jinxstage.setScene(scene);
        jinxstage.setTitle("7Wonders Architect");
        jinxstage.show();
    }

    //variables globales du jeu
    public static String[] pseudoPlayer = new String[7];
    public static String[] merveillesPlayer = new String[7];
    public static Joueurs[] joueursList = new Joueurs[7];
    public static int[] cardpos = {};
    public static int nbPlayer = 0;
    public static int playerTurn = 0;

    //merveilles declaration
    public static Rhodes rhodes = new Rhodes();
    public static Artemis artemis = new Artemis();
    public static Alexandrie alexandrie = new Alexandrie();
    public static Babylon babylon = new Babylon();
    public static Zeus zeus = new Zeus();
    public static Halicarnasse halicarnasse = new Halicarnasse();
    public static Gizeh gizeh = new Gizeh();


    //Cartes
    public static Cartes Bois = new Cartes_Grises("Bois");
    public static Cartes Brique = new Cartes_Grises("Brique");
    public static Cartes Pierre = new Cartes_Grises("Pierre");
    public static Cartes Verre = new Cartes_Grises("Verre");
    public static Cartes Parchemin = new Cartes_Grises("Parchemin");

    public static Cartes Or = new Cartes_Jaunes("Or");

    public static Cartes Point = new Cartes_Bleues("Point de victoire");
    public static Cartes Point_Chat = new Cartes_Bleues("Point de victoire avec le pion chat");

    public static Cartes Engrenage = new Cartes_Vertes("Engrenage");
    public static Cartes Compas = new Cartes_Vertes("Compas");
    public static Cartes Tablette = new Cartes_Vertes("Tablette");

    public static Cartes Bouclier = new Cartes_Rouges("Bouclier");
    public static Cartes Bouclier_corne1 = new Cartes_Rouges("Bouclier avec 1 corne");
    public static Cartes Bouclier_corne2 = new Cartes_Rouges("Bouclier avec 2 cornes");
    //Jetons
    public static Jetons Conflit = new Jeton_Conflit("Jeton de conflit");
    public static Jetons Progres = new Jeton_Progres("Jeton de progres");
    public static Jetons Victoire_militaire = new Jeton_Victoir_Militaire("Jeton de victoire militaire");
}
