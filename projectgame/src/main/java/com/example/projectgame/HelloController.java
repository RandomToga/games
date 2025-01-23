package com.example.projectgame;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    private char nowSym = 'x';
    private char gameField[][] = new char [3][3];
    private boolean isGame = true;

    @FXML
    void alerting(Button btn){
        isGame = false;
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Выиграл: \"" + btn.getText() + "\"", ButtonType.OK);
        alert.showAndWait();
    }
    @FXML
    void btnClick(ActionEvent event) {
        Button btn = (Button) event.getSource();
        if (!isGame || btn.getText() != "") return;

        int rowIndex = GridPane.getRowIndex(btn) == null ? 0 : GridPane.getRowIndex(btn);
        int columnIndex = GridPane.getColumnIndex(btn) == null ? 0 : GridPane.getColumnIndex(btn);
        //нужно было для проверки правильности пикания кнопок
        //System.out.println(rowIndex);
        //System.out.println(columnIndex);
        gameField[rowIndex][columnIndex] = nowSym;
        btn.setText(String.valueOf(nowSym));
        //проверка 1го ряда на победу
        if(gameField[0][0]==gameField[0][1] && gameField[0][0]==gameField[0][2] && (gameField[0][0]=='x' || gameField[0][0] == 'o')) {
            alerting(btn);
        }
        //проверка 2го ряда на победу
        else if(gameField[1][0]==gameField[1][1] && gameField[1][0]==gameField[1][2] && (gameField[1][0]=='x' || gameField[1][0] == 'o')) {
            alerting(btn);
        }
        //3 ряд
        else if(gameField[2][0]==gameField[2][1] && gameField[2][0]==gameField[2][2] && (gameField[2][0]=='x' || gameField[2][0] == 'o')) {
            alerting(btn);
        }
        //1 столб
        else if(gameField[0][0]==gameField[1][0] && gameField[0][0]==gameField[2][0] && (gameField[0][0]=='x' || gameField[0][0] == 'o')) {
            alerting(btn);
        }
        //2 столб
        else if(gameField[0][1]==gameField[1][1] && gameField[0][1]==gameField[2][1] && (gameField[0][1]=='x' || gameField[0][1] == 'o')) {
            alerting(btn);
        }
        //3 столб
        else if(gameField[0][2]==gameField[1][2] && gameField[0][2]==gameField[2][2] && (gameField[0][2]=='x' || gameField[0][2] == 'o')) {
            alerting(btn);
        }
        //диагональ
        else if(gameField[0][0]==gameField[1][1] && gameField[0][0]==gameField[2][2] && (gameField[0][0]=='x' || gameField[0][0] == 'o')) {
            alerting(btn);
        }
        //второстепенная диагональ
        else if(gameField[0][2]==gameField[1][1] && gameField[0][2]==gameField[2][0] && (gameField[0][2]=='x' || gameField[0][2] == 'o')) {
            alerting(btn);
        }
        nowSym = nowSym == 'x' ? 'o' : 'x';
    }

    @FXML
    void initialize() {

    }

}
