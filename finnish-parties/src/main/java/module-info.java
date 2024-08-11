module com.finnishparties {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.finnishparties to javafx.fxml;
    exports com.finnishparties;
}