package GUI;

import Exceptions.IllegalCard;
import Exceptions.IllegalGame;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage)  {
        Pane pane = new Pane();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(pane, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
        try {
            new Controller();
        } catch (IllegalGame illegalGame) {
            illegalGame.printStackTrace();
        }
    }
}
