module com.example.greenenergyweek910 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.greenenergyweek910 to javafx.fxml;
    exports com.example.greenenergyweek910;
}