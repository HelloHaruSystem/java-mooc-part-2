module com.notifier {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.notifier to javafx.fxml;
    exports com.notifier;
}