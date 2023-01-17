package com.example._7wondersarchitect;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable{
    @FXML
    private Text test;
    @FXML
    private Text test1;
    @FXML
    private Text test10;
    @FXML
    private Text test11;
    @FXML
    private Text test12;
    @FXML
    private Text test13;
    @FXML
    private Text test14;
    @FXML
    private Text test2;
    @FXML
    private Text test3;
    @FXML
    private Text test4;
    @FXML
    private Text test5;
    @FXML
    private Text test6;
    @FXML
    private Text test7;
    @FXML
    private Text test8;
    @FXML
    private Text test9;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        test.setText(jinx_aff.merveillesPlayer[0]);
        test1.setText(jinx_aff.merveillesPlayer[1]);
        test2.setText(jinx_aff.merveillesPlayer[2]);
        test3.setText(jinx_aff.merveillesPlayer[3]);
        test4.setText(jinx_aff.merveillesPlayer[4]);
        test5.setText(jinx_aff.merveillesPlayer[5]);
        test6.setText(jinx_aff.merveillesPlayer[6]);
        test7.setText(jinx_aff.pseudoPlayer[0]);
        test8.setText(jinx_aff.pseudoPlayer[1]);
        test9.setText(jinx_aff.pseudoPlayer[2]);
        test10.setText(jinx_aff.pseudoPlayer[3]);
        test11.setText(jinx_aff.pseudoPlayer[4]);
        test12.setText(jinx_aff.pseudoPlayer[5]);
        test13.setText(jinx_aff.pseudoPlayer[6]);
        test14.setText(Integer.toString(jinx_aff.nbPlayer));
    }
}