module com.tic_tac_toe {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tic_tac_toe to javafx.fxml;
    exports com.tic_tac_toe;
}