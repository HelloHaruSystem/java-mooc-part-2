module com.database {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.database to javafx.fxml;
    exports com.database;
}