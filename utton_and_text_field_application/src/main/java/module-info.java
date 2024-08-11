module com.utton_and_text_field_application {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.utton_and_text_field_application to javafx.fxml;
    exports com.utton_and_text_field_application;
}