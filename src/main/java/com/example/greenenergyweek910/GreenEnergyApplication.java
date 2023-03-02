package com.example.greenenergyweek910;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class GreenEnergyApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        AnchorPane anchorPane = new AnchorPane();
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane);

        stage.setTitle("Green Energy");
        stage.setScene(scene);
        stage.show();

        gridPane.getChildren().addAll(anchorPane);

    }

    public static void main(String[] args) {
        launch();
    }
}