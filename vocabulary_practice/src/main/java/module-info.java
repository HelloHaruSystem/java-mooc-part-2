module com.vocabulary_practice {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.vocabulary_practice to javafx.fxml;
    exports com.vocabulary_practice;
}