package com.example._7wondersarchitect;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;


public class GameController implements Initializable{


    @FXML
    private ImageView imgPlayerTurn1,imgPlayerTurn2,imgPlayerTurn3,imgPlayerTurn4,imgPlayerTurn5,imgPlayerTurn6,imgPlayerTurn7;
    @FXML
    private Text psuedoPlayer1,psuedoPlayer2,psuedoPlayer3,psuedoPlayer4,psuedoPlayer5,psuedoPlayer6,psuedoPlayer7;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ImageView[] tabimgPlayerTurn = {imgPlayerTurn1,imgPlayerTurn2,imgPlayerTurn3,imgPlayerTurn4,imgPlayerTurn5,imgPlayerTurn6,imgPlayerTurn7};
        int[] tabWaitingP = {550,450,350,250,150,50,0};
        int[] tabWaitingPpsuedo = {510,410,310,210,110,10,0};
        Text[] tabpsuedoPlayer = {psuedoPlayer1,psuedoPlayer2,psuedoPlayer3,psuedoPlayer4,psuedoPlayer5,psuedoPlayer6,psuedoPlayer7};
        Image alexandriaImage = new Image(new File("src/main/resources/images/finish/all_wonders/alexandria_choice.png").toURI().toString());
        Image artemisimage = new Image(new File("src/main/resources/images/finish/all_wonders/artemis_choice.png").toURI().toString());
        Image babylonimage = new Image(new File("src/main/resources/images/finish/all_wonders/babylon_choice.png").toURI().toString());
        Image gizehimage = new Image(new File("src/main/resources/images/finish/all_wonders/gizeh_choice.png").toURI().toString());
        Image hallicarnasimage = new Image(new File("src/main/resources/images/finish/all_wonders/hallicarnas_choice.png").toURI().toString());
        Image rhodesimage = new Image(new File("src/main/resources/images/finish/all_wonders/rhodes_choice.png").toURI().toString());
        Image zeusimage = new Image(new File("src/main/resources/images/finish/all_wonders/zeus_choice.png").toURI().toString());

        for(int i=1;i<jinx_aff.nbPlayer;i++) {
            tabimgPlayerTurn[i].setLayoutY(100);
            tabimgPlayerTurn[i].setLayoutX(tabWaitingP[jinx_aff.nbPlayer - 2] + 200 * (i-1));
            tabpsuedoPlayer[i].setLayoutY(230);
            tabpsuedoPlayer[i].setLayoutX(tabWaitingPpsuedo[jinx_aff.nbPlayer - 2] + 200 * (i-1));
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
        }
    }
}