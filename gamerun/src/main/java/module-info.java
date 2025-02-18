module com.example.gamerun {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gamerun to javafx.fxml;
    exports com.example.gamerun;
}