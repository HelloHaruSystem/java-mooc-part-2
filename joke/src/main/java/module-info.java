module com.joke {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.joke to javafx.fxml;
    exports com.joke;
}