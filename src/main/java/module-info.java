module com.example.kentavr {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.kentavr to javafx.fxml;
    exports com.example.kentavr;
}