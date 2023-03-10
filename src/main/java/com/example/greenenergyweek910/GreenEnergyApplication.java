package com.example.greenenergyweek910;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class GreenEnergyApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        ArrayList<String> idList = new ArrayList<>();
        ArrayList<String> sIdList = new ArrayList<>();
        ArrayList<String> totalList = new ArrayList<>();
        ArrayList<String> onlineProd = new ArrayList<>();
        ArrayList<String> tidOgDatoList = new ArrayList<>();
        ArrayList<String> sIdNoDupes = new ArrayList<>();
        ArrayList<String> locations = new ArrayList<>();
        ArrayList<Integer> onlineProdIntArr = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\David\\Desktop\\Green-energy-week-9-10-master\\src\\main\\java\\com\\example\\greenenergyweek910\\Udtræk af data fra solcelleanlæg.tsv"));
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

        ArrayList<String> dato = new ArrayList<>();
        for (int i = 0; i < tidOgDatoList.size(); i++) {
            String date1 = tidOgDatoList.get(i);
            date1 = date1.substring(0, 10);
            dato.add(date1);
        }

        HashSet<String> setWithoutDuplicates = new HashSet<String>(dato);
        dato.clear();
        dato.addAll(setWithoutDuplicates);
        Collections.sort(dato);
        System.out.println(dato);




        Map<String, List<String>> groupedData = new HashMap<>();
        for (int i = 0; i < tidOgDatoList.size(); i++) {
            String date = tidOgDatoList.get(i).substring(0, 10);
            String data = idList.get(i) + "\t" + tidOgDatoList.get(i) + "\t" + sIdList.get(i) + "\t" + totalList.get(i) + "\t" + onlineProd.get(i);
            if (groupedData.containsKey(date)) {
                groupedData.get(date).add(data);
            } else {
                List<String> dataList = new ArrayList<>();
                dataList.add(data);
                groupedData.put(date, dataList);
            }
        }

        Map<String, List<String>> groups = new HashMap<>();
        for (int i = 0; i < idList.size(); i++) {
            String date = tidOgDatoList.get(i).split(" ")[0]; // extract the date from the timestamp
            if (!groups.containsKey(date)) {
                groups.put(date, new ArrayList<>());
            }
            String data = idList.get(i) + "\t" + tidOgDatoList.get(i) + "\t" + sIdList.get(i) + "\t" + totalList.get(i) + "\t" + onlineProd.get(i);
            groups.get(date).add(data);
        }

// print out the groups
        for (Map.Entry<String, List<String>> entry : groups.entrySet()) {
            String date = entry.getKey();
            List<String> groupData = entry.getValue();
            // System.out.println("Data for " + date + ":");
            for (String data : groupData) {
                // System.out.println(data);
            }
        }

        ArrayList<Integer> totalListInt = new ArrayList<>();
        for (String str : onlineProd) {
            onlineProdIntArr.add(Integer.parseInt(str));
        }

        long number2 = 0;
        long onlineProdInt = 0;
        for (int i = 0; i < onlineProdIntArr.size()-1 ;i++) {

            onlineProdInt = number2 += onlineProdIntArr.get(i);
            // System.out.println( onlineProdInt );
        }


        GridPane gridPane = new GridPane();
        //ImageView background = new ImageView(getClass().getResource("/images/--Pngtree--beautiful nature blue sky with_5499997.png").toString());
        VBox leftVbox = new VBox();
        VBox rightVbox = new VBox();
        VBox buttomVbox = new VBox();
        Scene scene = new Scene(gridPane);
        Slider slider = new Slider(1,31,1);
        stage.setTitle("Green Energy");
        stage.setScene(scene);
        stage.getIcons().add(new Image("C:\\Users\\David\\Desktop\\Green-energy-week-9-10-master\\src\\main\\java\\com\\example\\greenenergyweek910\\projekt-logo.png")); // ligger under src som download.jpg en lille fin sol <3 husk backslahes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        stage.show();
        stage.setWidth(gridPane.getWidth());
        stage.setHeight(gridPane.getHeight());
        buttomVbox.setAlignment(Pos.CENTER);
        gridPane.setAlignment(Pos.TOP_LEFT);




        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\David\\Desktop\\Green-energy-week-9-10-master\\src\\main\\java\\com\\example\\greenenergyweek910\\f056c528-f5f4-4ce9-b6d9-5562174c030f (1).csv"));
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                sIdNoDupes.add(parts[1]);
                locations.add(parts[4]);
                line = reader.readLine();
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(locations);

        HashMap<String,String> sIdToLocation = new HashMap<>();
        for (int i = 0; i < sIdNoDupes.size()-1 ; i++) {
            sIdToLocation.put(sIdNoDupes.get(i), locations.get(i));
        }

        HashSet<String> sIdSetNoDupes = new HashSet<>(sIdList);
        ArrayList<String> sIdListNoDupes = new ArrayList<>(sIdSetNoDupes);

        int numberOfFlags = sIdListNoDupes.size();

        MenuButton menuButton = new MenuButton("Anlæg");
        for (int i = 0; i < 63; i++) {
            String sId = sIdListNoDupes.get(i);
            String location = locations.get(i);
            MenuItem menuItem = new MenuItem(location); // use location as label
            menuItem.setUserData(sId); // set sId as user data
            menuItem.setOnAction(event -> {
                String selectedLocation = (String) menuItem.getText();
                String selectedSId = ((String) menuItem.getUserData()); // assign value to selectedSId
                // handle menu item click event here
                System.out.println(selectedSId);
                menuButton.setText(selectedLocation);
            });
            menuButton.getItems().add(menuItem);
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
        String[] timer = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23",};

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Time");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Energy Generated (KW/T)");

        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Energy Production");

        for (int i = 0; i < timer.length; i++) {
            series.getData().add(new XYChart.Data<>(timer[i] + ":00", onlineProdIntArr.get(i)));
        }

        barChart.getData().add(series);

        barChart.setPrefSize(600,500);
        menuButton.setMinSize(125,25);

        //Add to gridpane
        gridPane.add(barChart,2,1);
        gridPane.add(slider,2,2);
        gridPane.add(rightVbox,3,1);
        gridPane.add(leftVbox,1,1);
        gridPane.add(buttomVbox,2,3);
        leftVbox.getChildren().add(menuButton);
        rightVbox.getChildren().add((createLabel("Den summerede energiproduktion for måneden: " + onlineProdInt,"Kw/t",13)));
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

            int index = (int) chosenDay - 1;
            String chosenTidOgDato = dato.get(index);
            System.out.println("Chosen Dato: " + chosenTidOgDato);
        });




        //Her kan du se antal rows og columns
//        System.out.println(gridPane.getRowCount());
//        System.out.println(gridPane.getColumnCount());
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