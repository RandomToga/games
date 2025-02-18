package com.example.gamerun;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView player, wlppr1, wlppr2;
    private final int WLPPR_WIDTH = 740;
    private ParallelTransition parallelTransition;

    public static boolean left = false;

    public static boolean right = false;

    public static boolean jump = false;

    private int player_speed = 3, jump_speed = 5;

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l){
            if(jump && player.getLayoutY()>90f)
                player.setLayoutY(player.getLayoutY()-jump_speed);
            else if(player.getLayoutY()<=181f){
                jump = false;
                player.setLayoutY(player.getLayoutY()+jump_speed);
            }
            if (right && player.getLayoutX()<200f)
                player.setLayoutX(player.getLayoutX()+player_speed);
            if (left && player.getLayoutX()>20f)
                player.setLayoutX(player.getLayoutX()-player_speed);
        }
    };

    @FXML
    void initialize() {
        TranslateTransition wlppr1trans = new TranslateTransition(Duration.millis(5000), wlppr1);
        wlppr1trans.setFromX(0);
        wlppr1trans.setToX(WLPPR_WIDTH*(-1));
        wlppr1trans.setInterpolator(Interpolator.LINEAR);
        TranslateTransition wlppr2trans = new TranslateTransition(Duration.millis(5000), wlppr2);
        wlppr2trans.setFromX(0);
        wlppr2trans.setToX(WLPPR_WIDTH*(-1));
        wlppr2trans.setInterpolator(Interpolator.LINEAR);

        parallelTransition = new ParallelTransition(wlppr1trans, wlppr2trans);
        parallelTransition.setCycleCount(Animation.INDEFINITE);
        parallelTransition.play();
        timer.start();
    }

}
