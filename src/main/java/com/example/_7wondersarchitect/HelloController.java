package com.example._7wondersarchitect;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("C'est quoi un homicide ?");
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