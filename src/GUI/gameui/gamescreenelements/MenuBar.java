package GUI.gameui.gamescreenelements;

import GUI.Controller;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.text.SimpleDateFormat;
import java.util.function.Consumer;


public class MenuBar extends HBox {
    public MenuBar(){

        this.init();
    }

    public Button quitButton = new Button("Quit");
    public Label timeStamp = new Label("Loading...");

    private void init(){
        this.setStyle("-fx-background-color: lightgray");

        this.getChildren().addAll(
                timeStamp,
                new Label("         "),
                quitButton
        );

    }
}
