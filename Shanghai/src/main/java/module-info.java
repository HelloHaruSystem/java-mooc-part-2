module com.shanghai {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.shanghai to javafx.fxml;
    exports com.shanghai;
}