package GUI.gameui.gamescreenelements;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.text.SimpleDateFormat;


public class MenuBar extends HBox {
    public MenuBar(){

        this.init();
    }

    public Button quitButton = new Button("Quit");
    private Label timeStamp = new Label("Loading...");

    private void init(){
        this.setStyle("-fx-background-color: lightgray");

        this.getChildren().addAll(
                timeStamp,
                new Label("         "),
                quitButton
        );

        this.createTimeThread();
    }

    private void createTimeThread(){
        new Thread(() -> {
            while (Platform.isFxApplicationThread()){
                try{
                    var time = new SimpleDateFormat("MMM dd, hh:mm").format(System.currentTimeMillis());
                    this.timeStamp.setText(time);

                    Thread.sleep(10000);
                } catch (Exception ignored) {}
            }

        }).start();
    }
}
