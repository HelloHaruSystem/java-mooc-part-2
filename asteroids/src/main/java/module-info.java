module com.asteroids {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.asteroids to javafx.fxml;
    exports com.asteroids;
    opens com.asteroids.ui to javafx.graphics;
    exports com.asteroids.ui;

}