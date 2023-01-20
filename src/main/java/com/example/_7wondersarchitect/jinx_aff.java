package com.example._7wondersarchitect;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class jinx_aff extends Application
{
    public static Stage jinxstage;
    private static FXMLLoader loader;

    public void jinx_launch(){
        launch();
    }
    @Override
    public void start(Stage stage) throws IOException
    {
        jinx_aff.setStage(stage);
        jinx_aff.loadFXMLScene("hello-view.fxml");

    }

    public static void setStage(Stage stage)
    {
        jinxstage = stage;
    }

    public static void loadFXMLScene(String path) throws IOException
    {
        // Create a new FXMLLoader object
        loader = new FXMLLoader(Main.class.getResource(path));
        // Load the FXML file
        Parent root = loader.load();
        // Set the root node of the scene to the newly loaded FXML file
        Scene scene = new Scene(root);
        jinxstage.setScene(scene);
        jinxstage.setTitle("7Wonders Architect");
        jinxstage.show();
    }

    public static String[] pseudoPlayer = new String[7];
    public static String[] merveillesPlayer = new String[7];
    public static int nbPlayer = 0;
}
