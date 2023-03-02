package com.example.greenenergyweek910;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
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
        stage.getIcons().add(new Image("C:\\Users\\søren n jessen\\OneDrive\\Dokumenter\\GitHub\\Green-energy-week-9-10\\src\\download.jpg")); // ligger under src som download.jpg en lille fin sol <3 husk backslahes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        stage.show();

        gridPane.add(new Text("Ved ikke lige hvad vi skal sætte her, har bare lige pillet lidt rundt"),0,0);


        gridPane.getChildren().addAll(anchorPane);

        //Her kan du se antal rows og columns
        gridPane.getColumnCount();
        gridPane.getRowCount();
        System.out.println(gridPane.getRowCount());
        System.out.println(gridPane.getColumnCount());

        //Her kan vi adde rows og columns
        //gridPane.addColumn();
        //gridPane.addRow();

    }

    public static void main(String[] args) {
        launch();
    }
}