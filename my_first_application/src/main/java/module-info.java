module com.my_first_application {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.my_first_application to javafx.fxml;
    exports com.my_first_application;
}