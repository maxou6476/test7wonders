package com.example._7wondersarchitect;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;


public class GameController implements Initializable{


    @FXML
    private ImageView imgPlayerTurn1,imgPlayerTurn2,imgPlayerTurn3,imgPlayerTurn4,imgPlayerTurn5,imgPlayerTurn6,imgPlayerTurn7;
    @FXML
    private ImageView imgCarteDeck,imgCarteJoueur1,imgCarteJoueur2,imgCarteJoueur3,imgCarteJoueur4,imgCarteJoueur5,imgCarteJoueur6,imgCarteJoueur7;
    @FXML
    private Text psuedoPlayer1,psuedoPlayer2,psuedoPlayer3,psuedoPlayer4,psuedoPlayer5,psuedoPlayer6,psuedoPlayer7;

    private int playerTurn = 0,playerCarte = 0;



    void scaleUp(ImageView imageview){
        imageview.setScaleX(1.5);
        imageview.setScaleY(1.5);
    }
    void scaleDown(ImageView imageview){
        imageview.setScaleX(1);
        imageview.setScaleY(1);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ImageView[] tabimgPlayerTurn = {imgPlayerTurn1,imgPlayerTurn2,imgPlayerTurn3,imgPlayerTurn4,imgPlayerTurn5,imgPlayerTurn6,imgPlayerTurn7};
        Text[] tabpsuedoPlayer = {psuedoPlayer1,psuedoPlayer2,psuedoPlayer3,psuedoPlayer4,psuedoPlayer5,psuedoPlayer6,psuedoPlayer7};
        int[] tabWaitingP = {550,450,350,250,150,50,0};
        int[] tabWaitingPpsuedo = {510,410,310,210,110,10,0};

        ImageView[] tabimgCarte = {imgCarteJoueur1,imgCarteJoueur2,imgCarteJoueur3,imgCarteJoueur4,imgCarteJoueur5,imgCarteJoueur6,imgCarteJoueur7};

        Image alexandriaImage = new Image(new File("src/main/resources/images/finish/all_wonders/alexandria_choice.png").toURI().toString());
        Image artemisimage = new Image(new File("src/main/resources/images/finish/all_wonders/artemis_choice.png").toURI().toString());
        Image babylonimage = new Image(new File("src/main/resources/images/finish/all_wonders/babylon_choice.png").toURI().toString());
        Image gizehimage = new Image(new File("src/main/resources/images/finish/all_wonders/gizeh_choice.png").toURI().toString());
        Image hallicarnasimage = new Image(new File("src/main/resources/images/finish/all_wonders/hallicarnas_choice.png").toURI().toString());
        Image rhodesimage = new Image(new File("src/main/resources/images/finish/all_wonders/rhodes_choice.png").toURI().toString());
        Image zeusimage = new Image(new File("src/main/resources/images/finish/all_wonders/zeus_choice.png").toURI().toString());
        Image carteAllImage = new Image(new File("src/main/resources/images/cartes.png").toURI().toString());

        PixelReader reader = carteAllImage.getPixelReader();
        Image deckImage = new WritableImage(reader,0,0,255,377);
        imgCarteDeck.setImage(deckImage);
        Image tile = new WritableImage(reader, 255, 0, 255, 377);
        imgCarteJoueur1.setImage(tile);
        Image tile2 = new WritableImage(reader, 510, 0, 255, 377);
        imgCarteJoueur2.setImage(tile2);

        //Placement des merveilles des joueurs
        for(int i=1;i<jinx_aff.nbPlayer;i++) {
            tabimgPlayerTurn[i].setLayoutY(50);
            tabimgPlayerTurn[i].setLayoutX(tabWaitingP[jinx_aff.nbPlayer - 2] + 200 * (i-1));
            tabpsuedoPlayer[i].setLayoutY(180);
            tabpsuedoPlayer[i].setLayoutX(tabWaitingPpsuedo[jinx_aff.nbPlayer - 2] + 200 * (i-1));
        }
        //placement des cartes des joueurs (pas le deck)
        for (int i=0;i<jinx_aff.nbPlayer;i++)
        {
            if(i == jinx_aff.nbPlayer-1){
                tabimgCarte[i].setLayoutY(75);
                tabimgCarte[i].setLayoutX(tabWaitingP[jinx_aff.nbPlayer - 2] + 200 * (i-1) + 50);
            }

        }
        for(int i=0;i<jinx_aff.nbPlayer;i++) {
            if (jinx_aff.merveillesPlayer[i] == "alexandria") {
                tabimgPlayerTurn[i].setImage(alexandriaImage);
            } else if (jinx_aff.merveillesPlayer[i] == "artemis") {
                tabimgPlayerTurn[i].setImage(artemisimage);
            } else if (jinx_aff.merveillesPlayer[i] == "babylon") {
                tabimgPlayerTurn[i].setImage(babylonimage);
            } else if (jinx_aff.merveillesPlayer[i] == "gizeh") {
                tabimgPlayerTurn[i].setImage(gizehimage);
            } else if (jinx_aff.merveillesPlayer[i] == "hallicarnas") {
                tabimgPlayerTurn[i].setImage(hallicarnasimage);
            } else if (jinx_aff.merveillesPlayer[i] == "rhodes") {
                tabimgPlayerTurn[i].setImage(rhodesimage);
            } else if (jinx_aff.merveillesPlayer[i] == "zeus") {
                tabimgPlayerTurn[i].setImage(zeusimage);
            }else{
                tabimgPlayerTurn[i].setImage(zeusimage);
            }

            tabpsuedoPlayer[i].setText(jinx_aff.pseudoPlayer[i]);

            imgCarteDeck.setOnMouseEntered(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent mouseEvent) {
                    scaleUp(imgCarteDeck);
                }
            });

            imgCarteDeck.setOnMouseExited(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent mouseEvent) {
                    scaleDown(imgCarteDeck);
                }
            });

/*
            tabimgCarte[playerTurn].setOnMouseEntered(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent mouseEvent) {
                    scaleUp(tabimgCarte[playerTurn]);
                }
            });

            tabimgCarte[playerTurn].setOnMouseExited(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent mouseEvent) {
                    scaleDown(tabimgCarte[playerTurn]);
                }
            });



            tabimgCarte[playerTurn-1].setOnMouseEntered(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent mouseEvent) {
                    scaleUp(tabimgCarte[playerTurn-1]);
                }
            });

            tabimgCarte[playerTurn-1].setOnMouseExited(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent mouseEvent) {
                    scaleDown(tabimgCarte[playerTurn-1]);
                }
            });
            */


        }
    }
}