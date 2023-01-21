package com.example._7wondersarchitect;

import javafx.event.ActionEvent;
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

    private int playerTurnTemp = jinx_aff.nbPlayer-1;



    void scaleUp(ImageView imageview){
        imageview.setScaleX(1.5);
        imageview.setScaleY(1.5);
    }
    void scaleDown(ImageView imageview){
        imageview.setScaleX(1);
        imageview.setScaleY(1);
    }


    @FXML
    void passTour(ActionEvent event) {
        jinx_aff.playerTurn++;
        if(jinx_aff.playerTurn == jinx_aff.nbPlayer){
            jinx_aff.playerTurn = 0;
        }
        changeImgMerv();
    }

    public void changeImgCard() {

    }

    public void changeImgMerv(){
        Text[] tabpsuedoPlayer = {psuedoPlayer1,psuedoPlayer2,psuedoPlayer3,psuedoPlayer4,psuedoPlayer5,psuedoPlayer6,psuedoPlayer7};
        ImageView[] tabimgPlayerTurn = {imgPlayerTurn1,imgPlayerTurn2,imgPlayerTurn3,imgPlayerTurn4,imgPlayerTurn5,imgPlayerTurn6,imgPlayerTurn7};

        Image alexandriaImage = new Image(new File("src/main/resources/images/finish/all_wonders/alexandria_choice.png").toURI().toString());
        Image artemisimage = new Image(new File("src/main/resources/images/finish/all_wonders/artemis_choice.png").toURI().toString());
        Image babylonimage = new Image(new File("src/main/resources/images/finish/all_wonders/babylon_choice.png").toURI().toString());
        Image gizehimage = new Image(new File("src/main/resources/images/finish/all_wonders/gizeh_choice.png").toURI().toString());
        Image hallicarnasimage = new Image(new File("src/main/resources/images/finish/all_wonders/hallicarnas_choice.png").toURI().toString());
        Image rhodesimage = new Image(new File("src/main/resources/images/finish/all_wonders/rhodes_choice.png").toURI().toString());
        Image zeusimage = new Image(new File("src/main/resources/images/finish/all_wonders/zeus_choice.png").toURI().toString());

        System.out.println(jinx_aff.playerTurn);

        for(int i=jinx_aff.playerTurn;i<jinx_aff.nbPlayer+jinx_aff.playerTurn;i++) {
            if (jinx_aff.merveillesPlayer[(i) - jinx_aff.playerTurn] == "alexandria") {
                tabimgPlayerTurn[(i) % jinx_aff.nbPlayer].setImage(alexandriaImage);
            } else if (jinx_aff.merveillesPlayer[(i) - jinx_aff.playerTurn] == "artemis") {
                tabimgPlayerTurn[(i) % jinx_aff.nbPlayer].setImage(artemisimage);
            } else if (jinx_aff.merveillesPlayer[(i) - jinx_aff.playerTurn] == "babylon") {
                tabimgPlayerTurn[(i) % jinx_aff.nbPlayer].setImage(babylonimage);
            } else if (jinx_aff.merveillesPlayer[(i) - jinx_aff.playerTurn] == "gizeh") {
                tabimgPlayerTurn[(i) % jinx_aff.nbPlayer].setImage(gizehimage);
            } else if (jinx_aff.merveillesPlayer[(i) - jinx_aff.playerTurn] == "hallicarnas") {
                tabimgPlayerTurn[(i) % jinx_aff.nbPlayer].setImage(hallicarnasimage);
            } else if (jinx_aff.merveillesPlayer[(i) - jinx_aff.playerTurn] == "rhodes") {
                tabimgPlayerTurn[(i) % jinx_aff.nbPlayer].setImage(rhodesimage);
            } else if (jinx_aff.merveillesPlayer[(i) - jinx_aff.playerTurn] == "zeus") {
                tabimgPlayerTurn[(i) % jinx_aff.nbPlayer].setImage(zeusimage);
            } else {
                tabimgPlayerTurn[(i) % jinx_aff.nbPlayer].setImage(zeusimage);
            }
            tabpsuedoPlayer[i % jinx_aff.nbPlayer].setText(jinx_aff.pseudoPlayer[i % jinx_aff.nbPlayer]);
        }
        
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        changeImgMerv();
        ImageView[] tabimgPlayerTurn = {imgPlayerTurn1,imgPlayerTurn2,imgPlayerTurn3,imgPlayerTurn4,imgPlayerTurn5,imgPlayerTurn6,imgPlayerTurn7};
        Text[] tabpsuedoPlayer = {psuedoPlayer1,psuedoPlayer2,psuedoPlayer3,psuedoPlayer4,psuedoPlayer5,psuedoPlayer6,psuedoPlayer7};
        int[] tabWaitingP = {550,450,350,250,150,50,0};
        int[] tabWaitingPpsuedo = {510,410,310,210,110,10,0};

        ImageView[] tabimgCarte = {imgCarteJoueur1,imgCarteJoueur2,imgCarteJoueur3,imgCarteJoueur4,imgCarteJoueur5,imgCarteJoueur6,imgCarteJoueur7};
        Image carteAllImage = new Image(new File("src/main/resources/images/cartes.png").toURI().toString());



        PixelReader reader = carteAllImage.getPixelReader();
        Image deckImage = new WritableImage(reader,0,0,255,377);
        imgCarteDeck.setImage(deckImage);
        Image tile = new WritableImage(reader, 255, 0, 255, 377);

        //Placement des merveilles des joueurs
        for(int i=1;i<jinx_aff.nbPlayer;i++) {
            tabimgPlayerTurn[i].setLayoutY(50);
            tabimgPlayerTurn[i].setLayoutX(tabWaitingP[jinx_aff.nbPlayer - 2] + 200 * (i-1));
            tabpsuedoPlayer[i].setLayoutY(180);
            tabpsuedoPlayer[i].setLayoutX(tabWaitingPpsuedo[jinx_aff.nbPlayer - 2] + 200 * (i-1));
        }
        //placement des cartes des joueurs (pas le deck)
        for (int i=1;i<jinx_aff.nbPlayer-1;i++)
        {
                tabimgCarte[i].setLayoutY(75);
                tabimgCarte[i].setLayoutX(tabWaitingP[jinx_aff.nbPlayer - 2] + 200 * (i-1) + 50);
        }
        tabimgCarte[jinx_aff.nbPlayer-1].setLayoutY(505);
        tabimgCarte[jinx_aff.nbPlayer-1].setLayoutX(852);
        tabimgCarte[jinx_aff.nbPlayer-1].setFitWidth(110);
        tabimgCarte[jinx_aff.nbPlayer-1].setFitHeight(140);
        for (int i=0;i<jinx_aff.nbPlayer;i++)
        {
            tabimgCarte[i].setImage(tile);
        }

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

            //interaction carte joueurs droite et gauche
            tabimgCarte[jinx_aff.playerTurn].setOnMouseEntered(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent mouseEvent) {
                    System.out.println(jinx_aff.playerTurn);
                    scaleUp(tabimgCarte[0]);
                }
            });

            tabimgCarte[jinx_aff.playerTurn].setOnMouseExited(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent mouseEvent) {
                    System.out.println(jinx_aff.playerTurn);
                    scaleDown(tabimgCarte[0]);
                }
            });

            //joueur - 1
                tabimgCarte[jinx_aff.nbPlayer-1].setOnMouseEntered(new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent mouseEvent) {
                        System.out.println(jinx_aff.nbPlayer-1);
                        scaleUp(tabimgCarte[jinx_aff.nbPlayer-1]);
                    }
                });

                tabimgCarte[jinx_aff.nbPlayer-1].setOnMouseExited(new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent mouseEvent) {
                        System.out.println(jinx_aff.nbPlayer-1);
                        scaleDown(tabimgCarte[jinx_aff.nbPlayer-1]);
                    }
                });


        
    }
}