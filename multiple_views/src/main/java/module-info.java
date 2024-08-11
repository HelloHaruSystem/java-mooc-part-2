module com.multiple_views {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.multiple_views to javafx.fxml;
    exports com.multiple_views;
}