package com.example._7wondersarchitect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class HelloController {

    @FXML
    private Slider slider_player;
    @FXML
    private Text nbPlayerText;

    @FXML
    private AnchorPane StartAnchor;

    @FXML
    private AnchorPane player1A;

    @FXML
    private AnchorPane player2A;

    @FXML
    private AnchorPane player3A;

    @FXML
    private AnchorPane player4A;

    @FXML
    private AnchorPane player5A;

    @FXML
    private AnchorPane player6A;

    @FXML
    private AnchorPane player7A;


    @FXML
    protected void switchscene() throws IOException {
            jinx_aff.loadFXMLScene("game-view.fxml");
    }

    @FXML
    void updatePlayerN(MouseEvent event) {
        AnchorPane[] tabplayer = {player3A,player4A,player5A,player6A,player7A};
        nbPlayerText.setText(String.valueOf((int)slider_player.getValue()));
        jinx_aff.showplayer((int)slider_player.getValue());

        StartAnchor.getChildren().remove(player3A);
        StartAnchor.getChildren().remove(player4A);
        StartAnchor.getChildren().remove(player5A);
        StartAnchor.getChildren().remove(player6A);
        StartAnchor.getChildren().remove(player7A);
        for(int i=0;i<(int)slider_player.getValue()-2;i++){
           StartAnchor.getChildren().add(tabplayer[i]);
        }

    }
}