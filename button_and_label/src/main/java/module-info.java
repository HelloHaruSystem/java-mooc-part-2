module com.button_and_label {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.button_and_label to javafx.fxml;
    exports com.button_and_label;
}