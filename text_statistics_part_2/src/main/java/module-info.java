module com.text_statistics_part_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.text_statistics_part_2 to javafx.fxml;
    exports com.text_statistics_part_2;
}