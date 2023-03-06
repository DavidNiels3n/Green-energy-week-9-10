package com.example.greenenergyweek910;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.io.IOException;

public class GreenEnergyApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane);

        MenuItem flagNumber1 = new MenuItem("Anlæg Nummer 1 ");
        MenuItem flagNumber2 = new MenuItem("Anlæg Nummer 2 ");
        MenuItem flagNumber3 = new MenuItem("Anlæg Nummer 3 ");
        MenuItem flagNumber4 = new MenuItem("Anlæg Nummer 4 ");
        MenuItem flagNumber5 = new MenuItem("Anlæg Nummer 5");
        MenuItem flagNumber6 = new MenuItem("Anlæg Nummer 6 ");
        MenuItem flagNumber7 = new MenuItem("Anlæg Nummer 7 ");
        MenuItem flagNumber8 = new MenuItem("Anlæg Nummer 8 ");
        MenuItem flagNumber9 = new MenuItem("Anlæg Nummer 9 ");
        MenuItem flagNumber10 = new MenuItem("Anlæg Nummer 10 ");
        MenuItem flagNumber11 = new MenuItem("Anlæg Nummer 11");
        MenuItem flagNumber12 = new MenuItem("Anlæg Nummer 12 ");
        MenuItem flagNumber13 = new MenuItem("Anlæg Nummer 13 ");
        MenuItem flagNumber14 = new MenuItem("Anlæg Nummer 14 ");
        MenuItem flagNumber15 = new MenuItem("Anlæg Nummer 15 ");
        MenuItem flagNumber16 = new MenuItem("Anlæg Nummer 16 ");
        MenuItem flagNumber17 = new MenuItem("Anlæg Nummer 17 ");
        MenuItem flagNumber18 = new MenuItem("Anlæg Nummer 18 ");
        MenuItem flagNumber19 = new MenuItem("Anlæg Nummer 19 ");
        MenuItem flagNumber20 = new MenuItem("Anlæg Nummer 20 ");

        MenuButton menuButton = new MenuButton("Anlæg", null, flagNumber1,flagNumber2,flagNumber3,flagNumber4,flagNumber5,flagNumber6,flagNumber7,flagNumber8,flagNumber9,flagNumber10,
                flagNumber11,flagNumber12,flagNumber13,flagNumber14,flagNumber15,flagNumber16,flagNumber17,flagNumber18,flagNumber19,flagNumber20);

        gridPane.add(menuButton,1,0,1,1);
//        ListView<String> solarPanelSites = new ListView<String>();
//        solarPanelSites.getItems().add("Anlæg nummer 1 ");
//        solarPanelSites.getItems().add("Anlæg nummer 2 ");
//        solarPanelSites.getItems().add("Anlæg nummer 3 ");
//        solarPanelSites.getItems().add("Anlæg nummer 4 ");
//        solarPanelSites.getItems().add("Anlæg nummer 5 ");
//        solarPanelSites.getItems().add("Anlæg nummer 6 ");
//        solarPanelSites.getItems().add("Anlæg nummer 7 ");
//        solarPanelSites.getItems().add("Anlæg nummer 8 ");
//        solarPanelSites.getItems().add("Anlæg nummer 9 ");
//        solarPanelSites.getItems().add("Anlæg nummer 10 ");
//        solarPanelSites.getItems().add("Anlæg nummer 11 ");
//        solarPanelSites.getItems().add("Anlæg nummer 12 ");
//        solarPanelSites.getItems().add("Anlæg nummer 13 ");
//        solarPanelSites.getItems().add("Anlæg nummer 14 ");
//        solarPanelSites.getItems().add("Anlæg nummer 15 ");
//        solarPanelSites.getItems().add("Anlæg nummer 16 ");
//        solarPanelSites.getItems().add("Anlæg nummer 17 ");
//        solarPanelSites.getItems().add("Anlæg nummer 18 ");
//        solarPanelSites.getItems().add("Anlæg nummer 19 ");
//        solarPanelSites.getItems().add("Anlæg nummer 20 ");
//
//
//        Button chooseData = new Button("Vis data fra dette site");
//
//        chooseData.setOnAction(event -> {
//            ObservableList<Integer> selectedIndices = solarPanelSites.getSelectionModel().getSelectedIndices();
//
//            for(Object o : selectedIndices){
//                System.out.println("o = " + o + " (" + o.getClass() + ")");
//            }
//        });

        stage.setTitle("Green Energy");
        stage.setScene(scene);
        stage.getIcons().add(new Image("C:\\Users\\David\\Documents\\GitHub\\Green-energy-week-9-10\\src\\download.jpg")); // ligger under src som download.jpg en lille fin sol <3 husk backslahes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        stage.show();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        stage.setWidth(1000);
        stage.setHeight(600);

       // Makes sure the program starts in the middle of the screen
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((screenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((screenBounds.getHeight() - stage.getHeight()) / 2);

//        gridPane.add(solarPanelSites,1,0,1,1);
//        gridPane.add(chooseData,1,1,1,1);



        //Her kan du se antal rows og columns
        gridPane.getColumnCount();
        gridPane.getRowCount();
        System.out.println(gridPane.getRowCount());
        System.out.println(gridPane.getColumnCount());

        //Her kan vi adde rows og columns ved dog ikke om vi bruger anchorpane nu?
        //gridPane.addColumn();
        //gridPane.addRow();




    }

    public static void main(String[] args) {
        launch();
    }
}