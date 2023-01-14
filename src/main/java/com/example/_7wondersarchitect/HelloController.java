package com.example._7wondersarchitect;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    private Stage stage;
    @FXML
    private Label welcomeText;

    @FXML
    protected void switchscene() throws IOException {

            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("game-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1200, 800);
            jinx_aff.stage.setTitle("Hello!");
            jinx_aff.stage.setScene(scene);
            jinx_aff.stage.show();
    }

    @FXML
    protected void onSecondButton() {
        welcomeText.setText("Affichage 2");
    }

    @FXML
    private Slider valueSliderPlayer;

    @FXML
    public void sliderTextDrag() {
        System.out.println("sheeesh");
        int sliderValue = (int) valueSliderPlayer.getValue();
        System.out.println(sliderValue + " ");
        welcomeText.setText(valueSliderPlayer.getValue()+" ");
    }



}