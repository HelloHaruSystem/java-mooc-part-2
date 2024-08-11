module com.text_statistics {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.text_statistics to javafx.fxml;
    exports com.text_statistics;
}