package com.example._7wondersarchitect;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable{

    @FXML
    private Slider slider_player;
    @FXML
    private Text nbPlayerText;
    @FXML
    private AnchorPane StartAnchor;

    @FXML
    private ImageView imageP1_choice,imageP2_choice,imageP3_choice,imageP4_choice,imageP5_choice,imageP6_choice,imageP7_choice;
    @FXML
    private TextArea pseudoP1,pseudoP2,pseudoP3,pseudoP4,pseudoP5,pseudoP6,pseudoP7;
    @FXML
    private ChoiceBox<String> Player1choicebox,Player2choicebox,Player3choicebox,Player4choicebox,Player5choicebox,Player6choicebox,Player7choicebox;
    @FXML
    private AnchorPane player1A,player2A,player3A,player4A,player5A,player6A,player7A;


    @FXML
    protected void switchscene() throws IOException {
        jinx_aff.pseudoPlayer[0] = pseudoP1.getText();
        jinx_aff.pseudoPlayer[1] = pseudoP2.getText();
        jinx_aff.pseudoPlayer[2] = pseudoP3.getText();
        jinx_aff.pseudoPlayer[3] = pseudoP4.getText();
        jinx_aff.pseudoPlayer[4] = pseudoP5.getText();
        jinx_aff.pseudoPlayer[5] = pseudoP6.getText();
        jinx_aff.pseudoPlayer[6] = pseudoP7.getText();
        jinx_aff.nbPlayer = (int)slider_player.getValue();
        jinx_aff.loadFXMLScene("game-view.fxml");
    }

    @FXML
    void updatePlayerN(MouseEvent event) {
        AnchorPane[] tabplayer = {player3A,player4A,player5A,player6A,player7A};
        nbPlayerText.setText(String.valueOf((int)slider_player.getValue()));

        StartAnchor.getChildren().remove(player3A);
        StartAnchor.getChildren().remove(player4A);
        StartAnchor.getChildren().remove(player5A);
        StartAnchor.getChildren().remove(player6A);
        StartAnchor.getChildren().remove(player7A);
        for(int i=0;i<(int)slider_player.getValue()-2;i++){
           StartAnchor.getChildren().add(tabplayer[i]);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ChoiceBox[] choiceboxtab = {Player1choicebox,Player2choicebox,Player3choicebox,Player4choicebox,Player5choicebox,Player6choicebox,Player7choicebox};

        for(int i=0;i<7;i++) {
            choiceboxtab[i].getItems().add("alexandria");
            choiceboxtab[i].getItems().add("artemis");
            choiceboxtab[i].getItems().add("babylon");
            choiceboxtab[i].getItems().add("gizeh");
            choiceboxtab[i].getItems().add("hallicarnas");
            choiceboxtab[i].getItems().add("rhodes");
            choiceboxtab[i].getItems().add("zeus");
        }

        Image alexandriaImage = new Image(new File("src/main/resources/images/finish/all_wonders/alexandria_choice.png").toURI().toString());
        Image artemisimage = new Image(new File("src/main/resources/images/finish/all_wonders/artemis_choice.png").toURI().toString());
        Image babylonimage = new Image(new File("src/main/resources/images/finish/all_wonders/babylon_choice.png").toURI().toString());
        Image gizehimage = new Image(new File("src/main/resources/images/finish/all_wonders/gizeh_choice.png").toURI().toString());
        Image hallicarnasimage = new Image(new File("src/main/resources/images/finish/all_wonders/hallicarnas_choice.png").toURI().toString());
        Image rhodesimage = new Image(new File("src/main/resources/images/finish/all_wonders/rhodes_choice.png").toURI().toString());
        Image zeusimage = new Image(new File("src/main/resources/images/finish/all_wonders/zeus_choice.png").toURI().toString());


        Player1choicebox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(choiceboxtab[0].getValue() == "alexandria"){
                    imageP1_choice.setImage(alexandriaImage);
                }else if(choiceboxtab[0].getValue() == "artemis"){
                    imageP1_choice.setImage(artemisimage);
                }else if(choiceboxtab[0].getValue() == "babylon"){
                    imageP1_choice.setImage(babylonimage);
                }else if(choiceboxtab[0].getValue() == "gizeh"){
                    imageP1_choice.setImage(gizehimage);
                }else if(choiceboxtab[0].getValue() == "hallicarnas"){
                    imageP1_choice.setImage(hallicarnasimage);
                }else if(choiceboxtab[0].getValue() == "rhodes"){
                    imageP1_choice.setImage(rhodesimage);
                }else if(choiceboxtab[0].getValue() == "zeus"){
                    imageP1_choice.setImage(zeusimage);
                }
                jinx_aff.merveillesPlayer[0] = (String)choiceboxtab[0].getValue();
            }
        });
        Player2choicebox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(choiceboxtab[1].getValue() == "alexandria"){
                    imageP2_choice.setImage(alexandriaImage);
                }else if(choiceboxtab[1].getValue() == "artemis"){
                    imageP2_choice.setImage(artemisimage);
                }else if(choiceboxtab[1].getValue() == "babylon"){
                    imageP2_choice.setImage(babylonimage);
                }else if(choiceboxtab[1].getValue() == "gizeh"){
                    imageP2_choice.setImage(gizehimage);
                }else if(choiceboxtab[1].getValue() == "hallicarnas"){
                    imageP2_choice.setImage(hallicarnasimage);
                }else if(choiceboxtab[1].getValue() == "rhodes"){
                    imageP2_choice.setImage(rhodesimage);
                }else if(choiceboxtab[1].getValue() == "zeus"){
                    imageP2_choice.setImage(zeusimage);
                }
                jinx_aff.merveillesPlayer[1] = (String)choiceboxtab[1].getValue();
            }
        });
        Player3choicebox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(choiceboxtab[2].getValue() == "alexandria"){
                    imageP3_choice.setImage(alexandriaImage);
                }else if(choiceboxtab[2].getValue() == "artemis"){
                    imageP3_choice.setImage(artemisimage);
                }else if(choiceboxtab[2].getValue() == "babylon"){
                    imageP3_choice.setImage(babylonimage);
                }else if(choiceboxtab[2].getValue() == "gizeh"){
                    imageP3_choice.setImage(gizehimage);
                }else if(choiceboxtab[2].getValue() == "hallicarnas"){
                    imageP3_choice.setImage(hallicarnasimage);
                }else if(choiceboxtab[2].getValue() == "rhodes"){
                    imageP3_choice.setImage(rhodesimage);
                }else if(choiceboxtab[2].getValue() == "zeus"){
                    imageP3_choice.setImage(zeusimage);
                }
                jinx_aff.merveillesPlayer[2] = (String)choiceboxtab[2].getValue();
            }
        });
        Player4choicebox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(choiceboxtab[4].getValue() == "alexandria"){
                    imageP4_choice.setImage(alexandriaImage);
                }else if(choiceboxtab[3].getValue() == "artemis"){
                    imageP4_choice.setImage(artemisimage);
                }else if(choiceboxtab[3].getValue() == "babylon"){
                    imageP4_choice.setImage(babylonimage);
                }else if(choiceboxtab[3].getValue() == "gizeh"){
                    imageP4_choice.setImage(gizehimage);
                }else if(choiceboxtab[3].getValue() == "hallicarnas"){
                    imageP4_choice.setImage(hallicarnasimage);
                }else if(choiceboxtab[3].getValue() == "rhodes"){
                    imageP4_choice.setImage(rhodesimage);
                }else if(choiceboxtab[3].getValue() == "zeus"){
                    imageP4_choice.setImage(zeusimage);
                }
                jinx_aff.merveillesPlayer[3] = (String)choiceboxtab[3].getValue();
            }
        });
        Player5choicebox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(choiceboxtab[4].getValue() == "alexandria"){
                    imageP5_choice.setImage(alexandriaImage);
                }else if(choiceboxtab[4].getValue() == "artemis"){
                    imageP5_choice.setImage(artemisimage);
                }else if(choiceboxtab[4].getValue() == "babylon"){
                    imageP5_choice.setImage(babylonimage);
                }else if(choiceboxtab[4].getValue() == "gizeh"){
                    imageP5_choice.setImage(gizehimage);
                }else if(choiceboxtab[4].getValue() == "hallicarnas"){
                    imageP5_choice.setImage(hallicarnasimage);
                }else if(choiceboxtab[4].getValue() == "rhodes"){
                    imageP5_choice.setImage(rhodesimage);
                }else if(choiceboxtab[4].getValue() == "zeus"){
                    imageP5_choice.setImage(zeusimage);
                }
                jinx_aff.merveillesPlayer[4] = (String)choiceboxtab[4].getValue();
            }
        });
        Player6choicebox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(choiceboxtab[5].getValue() == "alexandria"){
                    imageP6_choice.setImage(alexandriaImage);
                }else if(choiceboxtab[5].getValue() == "artemis"){
                    imageP6_choice.setImage(artemisimage);
                }else if(choiceboxtab[5].getValue() == "babylon"){
                    imageP6_choice.setImage(babylonimage);
                }else if(choiceboxtab[5].getValue() == "gizeh"){
                    imageP6_choice.setImage(gizehimage);
                }else if(choiceboxtab[5].getValue() == "hallicarnas"){
                    imageP6_choice.setImage(hallicarnasimage);
                }else if(choiceboxtab[5].getValue() == "rhodes"){
                    imageP6_choice.setImage(rhodesimage);
                }else if(choiceboxtab[5].getValue() == "zeus"){
                    imageP6_choice.setImage(zeusimage);
                }
                jinx_aff.merveillesPlayer[5] = (String)choiceboxtab[5].getValue();
            }
        });
        Player7choicebox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(choiceboxtab[6].getValue() == "alexandria"){
                    imageP7_choice.setImage(alexandriaImage);
                }else if(choiceboxtab[6].getValue() == "artemis"){
                    imageP7_choice.setImage(artemisimage);
                }else if(choiceboxtab[6].getValue() == "babylon"){
                    imageP7_choice.setImage(babylonimage);
                }else if(choiceboxtab[6].getValue() == "gizeh"){
                    imageP7_choice.setImage(gizehimage);
                }else if(choiceboxtab[6].getValue() == "hallicarnas"){
                    imageP7_choice.setImage(hallicarnasimage);
                }else if(choiceboxtab[6].getValue() == "rhodes"){
                    imageP7_choice.setImage(rhodesimage);
                }else if(choiceboxtab[6].getValue() == "zeus"){
                    imageP7_choice.setImage(zeusimage);
                }
                jinx_aff.merveillesPlayer[6] = (String)choiceboxtab[6].getValue();
            }
        });
    }
}