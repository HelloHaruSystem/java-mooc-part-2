module com.users_title {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.users_title to javafx.fxml;
    exports com.users_title;
}