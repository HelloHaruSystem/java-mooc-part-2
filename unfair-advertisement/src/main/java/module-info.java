module com.unfairadvertisement {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.unfairadvertisement to javafx.fxml;
    exports com.unfairadvertisement;
}