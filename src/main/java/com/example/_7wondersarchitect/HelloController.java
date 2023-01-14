package com.example._7wondersarchitect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;

public class HelloController {

    @FXML
    private Slider slider_player;
    @FXML
    private Text nbPlayerText;


    @FXML
    protected void switchscene() throws IOException {
            jinx_aff.loadFXMLScene("game-view.fxml");
    }

    @FXML
    void updatePlayerN(MouseEvent event) {
        nbPlayerText.setText(String.valueOf((int)slider_player.getValue()));
    }
}