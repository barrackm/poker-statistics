package GUI;

import Exceptions.IllegalCard;
import Exceptions.IllegalGame;
import GUI.gameui.GameScreen;
import GUI.gameui.StartScreen;
import Logic.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {
    private Game game;
    private final StartScreen startScreen = new StartScreen();
    private final GameScreen gameScreen = new GameScreen();
    private final Stage stage;


    public Controller(Stage stage) throws IllegalGame {
        this.stage = stage;

        this.init();
    }

    private void init() {
        stage.setTitle("Hello World");
        stage.setScene(new Scene(this.startScreen, 300, 275));

        this.startScreen.startGame.setOnAction(e -> this.stage.setScene(new Scene(this.gameScreen, 800, 500)));


        try{ this.game = new Game(3); } catch (Exception ignored) {}
        stage.show();
    }
}
