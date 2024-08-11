module com.savnignscalculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.savnignscalculator to javafx.fxml;
    exports com.savnignscalculator;
}