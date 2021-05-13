package GUI;

import Logic.Card;
import Logic.Deck;
import Logic.Hole;
import Logic.IllegalCard;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(pane, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) throws IllegalCard {
        launch(args);

        Deck deck = new Deck();
        deck.shuffle();
        deck.print();
        System.out.println("0000");
        Hole hole = new Hole(deck);
        hole.print();
        System.out.println("0000");
        deck.print();
    }
}
