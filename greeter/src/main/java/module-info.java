module com.greeter {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.greeter to javafx.fxml;
    exports com.greeter;
}