module com.cyclingstatistics {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.cyclingstatistics to javafx.fxml;
    exports com.cyclingstatistics;
}