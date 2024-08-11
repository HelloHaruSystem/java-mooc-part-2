module com.collage {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.collage to javafx.fxml;
    exports com.collage;
}