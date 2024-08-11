module com.borderpane {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.borderpane to javafx.fxml;
    exports com.borderpane;
}