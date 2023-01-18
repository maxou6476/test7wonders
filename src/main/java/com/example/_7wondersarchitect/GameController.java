package com.example._7wondersarchitect;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;


public class GameController implements Initializable{


    @FXML
    private ImageView imgPlayerTurn1,imgPlayerTurn2,imgPlayerTurn3,imgPlayerTurn4,imgPlayerTurn5,imgPlayerTurn6;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ImageView[] tabimgPlayerTurn = {imgPlayerTurn1,imgPlayerTurn2,imgPlayerTurn3,imgPlayerTurn4,imgPlayerTurn5,imgPlayerTurn6};
        int[] tabWaitingP = {550,450,350,250,150,50};
        System.out.println(jinx_aff.nbPlayer);
        for(int i=0;i<jinx_aff.nbPlayer-1;i++)
        {
            System.out.println(i);
            tabimgPlayerTurn[i].setLayoutY(100);
            tabimgPlayerTurn[i].setLayoutX(tabWaitingP[jinx_aff.nbPlayer-2]+200*i);
            System.out.println(tabWaitingP[i]);
        }
    }
}