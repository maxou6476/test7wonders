package com.example._7wondersarchitect;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class EndController {

    @FXML
    private Text playerRank1,playerRank2,playerRank3;

    public void initialize(){
        playerRank1.setText(jinx_aff.joueursList[0].getName());
        playerRank2.setText(jinx_aff.joueursList[1].getName());
        if(jinx_aff.nbPlayer >=3){
            playerRank3.setText(jinx_aff.joueursList[2].getName());
        }else{
            playerRank3.setText("");
        }


    }
}
