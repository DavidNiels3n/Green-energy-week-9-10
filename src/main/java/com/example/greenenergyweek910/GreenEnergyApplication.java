package com.example.greenenergyweek910;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class GreenEnergyApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {



        ArrayList<String> idList = new ArrayList<>();
        ArrayList<String> tidOgDatoList = new ArrayList<>();
        ArrayList<String> sIdList = new ArrayList<>();
        ArrayList<String> totalList = new ArrayList<>();
        ArrayList<String> onlineProd = new ArrayList<>();



        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\David\\Documents\\GitHub\\Green-energy-week-9-10\\src\\main\\java\\com\\example\\greenenergyweek910\\Udtræk af data fra solcelleanlæg.tsv"));
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split("\t");
                idList.add(parts[0]);
                tidOgDatoList.add(parts[1]);
                sIdList.add(parts[2]);
                totalList.add(parts[3]);
                onlineProd.add(parts[4]);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Integer> totalListInt = new ArrayList<>();
        for (String str : totalList) {
            totalListInt.add(Integer.parseInt(str));
        }


        long number2 = 0;
        long totalPreJan = 0;
        for (int i = 0; i < 60*24 ;i+=24) {

            totalPreJan = number2 += totalListInt.get(i);
           // System.out.println( totalPreJan );
        }
        long number3 = 0;
        long totalPostJan = 0;
        
        for (int i = totalListInt.size()-1; i > totalListInt.size()-1 - 60*24; i-=24) {

            totalPostJan = number3 += totalListInt.get(i);
           // System.out.println( totalPostJan );
        }

        long totalProdJan = totalPreJan - totalPostJan;

        System.out.println(totalProdJan);

        GridPane gridPane = new GridPane();
        //ImageView background = new ImageView(getClass().getResource("/images/--Pngtree--beautiful nature blue sky with_5499997.png").toString());
        VBox leftVbox = new VBox();
        VBox rightVbox = new VBox();
        VBox buttomVbox = new VBox();
        Scene scene = new Scene(gridPane);
        Slider slider = new Slider(1,31,1);
        stage.setTitle("Green Energy");
        stage.setScene(scene);
        stage.getIcons().add(new Image("C:\\Users\\David\\Documents\\GitHub\\Green-energy-week-9-10\\src\\main\\java\\com\\example\\greenenergyweek910\\projekt-logo.png")); // ligger under src som download.jpg en lille fin sol <3 husk backslahes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        stage.show();
        stage.setWidth(gridPane.getWidth());
        stage.setHeight(gridPane.getHeight());
        buttomVbox.setAlignment(Pos.CENTER);
      //  gridPane.setGridLinesVisible(true);
        gridPane.setAlignment(Pos.TOP_LEFT);




        //Menu stuff

        int numberOfFlags = 40; // specify the number of menu items to create
        MenuButton menuButton = new MenuButton("Anlæg");
        for (int i = 1; i <= numberOfFlags; i++) {
            MenuItem flagNumber = new MenuItem("Anlæg Nummer " + i);
            flagNumber.setOnAction(event -> {
                // handle menu item click event here
            });
            menuButton.getItems().add(flagNumber);
        }
       // Makes sure the program starts in the middle of the screen
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((screenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((screenBounds.getHeight() - stage.getHeight()) / 2);


        //slider
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setSnapToTicks(true);
        slider.setMajorTickUnit(1);
        slider.setMinorTickCount(0);

        //BARCHART

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Klokken");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("KW/T");

        BarChart barChart = new BarChart(xAxis, yAxis);

        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("Januar");

        dataSeries1.getData().add(new XYChart.Data("00:00", 0));
        dataSeries1.getData().add(new XYChart.Data("01:00"  , 0));
        dataSeries1.getData().add(new XYChart.Data("02:00"  , 0));
        dataSeries1.getData().add(new XYChart.Data("03:00", 0));
        dataSeries1.getData().add(new XYChart.Data("04:00"  , 0));
        dataSeries1.getData().add(new XYChart.Data("05:00"  , 0));
        dataSeries1.getData().add(new XYChart.Data("06:00", 0));
        dataSeries1.getData().add(new XYChart.Data("07:00"  , 5));
        dataSeries1.getData().add(new XYChart.Data("08:00"  , 10));
        dataSeries1.getData().add(new XYChart.Data("09:00", 15));
        dataSeries1.getData().add(new XYChart.Data("10:00"  , 25));
        dataSeries1.getData().add(new XYChart.Data("11:00"  , 40));
        dataSeries1.getData().add(new XYChart.Data("12:00", 100));
        dataSeries1.getData().add(new XYChart.Data("13:00"  , 150));
        dataSeries1.getData().add(new XYChart.Data("14:00"  , 250));
        dataSeries1.getData().add(new XYChart.Data("15:00", 150));
        dataSeries1.getData().add(new XYChart.Data("16:00"  , 100));
        dataSeries1.getData().add(new XYChart.Data("17:00"  , 40));
        dataSeries1.getData().add(new XYChart.Data("18:00", 25));
        dataSeries1.getData().add(new XYChart.Data("19:00"  , 20));
        dataSeries1.getData().add(new XYChart.Data("20:00"  , 10));
        dataSeries1.getData().add(new XYChart.Data("21:00", 0));
        dataSeries1.getData().add(new XYChart.Data("22:00"  , 0));
        dataSeries1.getData().add(new XYChart.Data("23:00"  , 0));

        barChart.getData().add(dataSeries1);
        barChart.setPrefSize(600,500);

        menuButton.setMinSize(125,25);

        //Add to gridpane
        gridPane.add(barChart,2,1);
        gridPane.add(slider,2,2);
        gridPane.add(rightVbox,3,1);
        gridPane.add(leftVbox,1,1);
        gridPane.add(buttomVbox,2,3);
        leftVbox.getChildren().add(menuButton);
        rightVbox.getChildren().add((createLabel("Den summerede energiproduktion for måneden: ", " Kw/t",13)));
        rightVbox.getChildren().add((createLabel("Dagen med den mindste produktion: ", idList.get(0),13)));
        rightVbox.getChildren().add((createLabel("Dagen med den største produktion: ", idList.get(0),13)));
        Label dayChooser = new Label();
        dayChooser.setText("Dag " + "1");
        dayChooser.setFont(new Font("Arial", 14));
        dayChooser.setTextFill(Color.BLACK);
        buttomVbox.getChildren().add(dayChooser);
        rightVbox.setAlignment(Pos.CENTER_LEFT);

        //slider listener. changes the day you choose in slider
        slider.valueProperty().addListener((observableValue, number, t1) -> {
            double chosenDay = slider.getValue();
            slider.setValue(chosenDay);
            String stringChosenDay = String.valueOf(Math.round(chosenDay));
            dayChooser.setText("Dag " + stringChosenDay);
        });




        //Her kan du se antal rows og columns
        System.out.println(gridPane.getRowCount());
        System.out.println(gridPane.getColumnCount());
    }

    public Label createLabel(String labelText, String Data, int fontSize) {
        Label label = new Label(labelText + Data);
        label.setFont(new Font("Arial", fontSize));
        label.setTextFill(Color.BLACK);
        return label;
    }
    public static void main(String[] args) {
        launch();
    }
}