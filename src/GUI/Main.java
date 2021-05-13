package GUI;

import Exceptions.IllegalCard;
import Exceptions.IllegalGame;
import GUI.gameui.StartScreen;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    public StartScreen startScreen = new StartScreen();

    @Override
    public void start(Stage primaryStage) throws Exception {
        new Controller(primaryStage);
    }


    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
