module com.smiley {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.smiley to javafx.fxml;
    exports com.smiley;
}