module com.example.bohdanadressna {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires MaterialFX;


    opens com.example.bohdanadressna to javafx.fxml;
    exports com.example.bohdanadressna;
}