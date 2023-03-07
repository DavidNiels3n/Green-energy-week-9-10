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
import java.io.IOException;

public class GreenEnergyApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {


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
        barChart.setPrefSize(700,600);

        menuButton.setMinSize(125,25);

        //Add to gridpane
        gridPane.add(barChart,2,1);
        gridPane.add(slider,2,2);
        gridPane.add(rightVbox,3,1);
        gridPane.add(leftVbox,1,1);
        gridPane.add(buttomVbox,2,3);
        leftVbox.getChildren().add(menuButton);
        rightVbox.getChildren().add((createLabel("Den summerede energiproduktion for måneden: ", "515458",13)));
        rightVbox.getChildren().add((createLabel("Den summerede energiproduktion for måneden: ", "353",13)));
        rightVbox.getChildren().add((createLabel("Den summerede energiproduktion for måneden: ", "654655",13)));
        Label label = new Label();
        label.setText("Dag " + "1");
        label.setFont(new Font("Arial", 14));
        label.setTextFill(Color.BLACK);
        buttomVbox.getChildren().add(label);


        slider.valueProperty().addListener((observableValue, number, t1) -> {
            double chosenDay = slider.getValue();
            slider.setValue(chosenDay);
            String stringChosenDay = String.valueOf(Math.round(chosenDay));
            label.setText("Dag " + stringChosenDay);
        });

        buttomVbox.setAlignment(Pos.CENTER);
        gridPane.setGridLinesVisible(true);
        gridPane.setAlignment(Pos.TOP_LEFT);


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