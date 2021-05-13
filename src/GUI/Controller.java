package GUI;

import Exceptions.IllegalCard;
import Exceptions.IllegalGame;
import GUI.gameui.GameScreen;
import GUI.gameui.StartScreen;
import Logic.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;

public class Controller {
    private Game game;
    private final StartScreen startScreen = new StartScreen();
    private final GameScreen gameScreen = new GameScreen();
    public Stage stage;


    public Controller(Stage stage) throws IllegalGame {
        this.stage = stage;

        this.init();
    }

    private void init() {
        stage.setTitle("Hello World");
        stage.setScene(new Scene(this.startScreen, 300, 275));

        this.startScreen.startGame.setOnAction(e -> stage.setScene(new Scene(this.gameScreen, 800, 500)));


        try{ this.game = new Game(3); } catch (Exception ignored) {}

        this.createTimeThread();
        stage.show();
    }


    private void createTimeThread(){
        new Thread(() -> {
            while (this.stage.isShowing()){
                try{
                    var time = new SimpleDateFormat("MMM dd, hh:mm").format(System.currentTimeMillis());
                    this.gameScreen.menuBar.timeStamp.setText(time);

                    Thread.sleep(1000);
                } catch (Exception ignored) {}
            }

        }).start();
    }
}
