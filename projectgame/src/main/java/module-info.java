module com.example.projectgame {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.projectgame to javafx.fxml;
    exports com.example.projectgame;
}