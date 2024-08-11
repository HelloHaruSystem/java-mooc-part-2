module com.hurray {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.hurray to javafx.fxml;
    exports com.hurray;
}