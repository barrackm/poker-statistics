package GUI;

import Exceptions.IllegalCard;
import Exceptions.IllegalGame;
import GUI.gameui.GameScreen;
import GUI.gameui.StartScreen;
import Logic.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Controller {
    private Game game;
    private final StartScreen startScreen = new StartScreen();
    private final GameScreen gameScreen = new GameScreen();
    public Stage stage;
    private int numPlayers = 0;


    public Controller(Stage stage) throws IllegalGame {
        this.stage = stage;

        this.init();
    }

    private void init() {
        stage.setTitle("Hello World");
        stage.setScene(new Scene(this.startScreen, 300, 275));


        ArrayList<Card> cards = new ArrayList<>();
        try {
            cards.add(new Card(Card.Suit.SPADE, 1));
            cards.add(new Card(Card.Suit.HEART, 1));
            cards.add(new Card(Card.Suit.DIAMOND, 4));
            cards.add(new Card(Card.Suit.SPADE, 4));
            cards.add(new Card(Card.Suit.HEART, 6));
            cards.add(new Card(Card.Suit.DIAMOND, 8));
        } catch (IllegalCard illegalCard) {
            illegalCard.printStackTrace();
        };


        System.out.println(HandRankings.determineHand(cards));


        this.startScreen.startGame.setOnAction(e ->{
            try {
                this.game = new Game(numPlayers);
                stage.setScene(new Scene(this.gameScreen, 800, 500));
            } catch (IllegalGame illegalGame) {
                illegalGame.printStackTrace();
            }
        });

        this.startScreen.numberOfPlayers.setOnAction(e -> {
            String string = this.startScreen.numberOfPlayers.getText();
            try {
                numPlayers = Integer.parseInt(string);
            } catch (Exception ignored) {}
        });

        this.startScreen.numberOfPlayers.focusedProperty().addListener(e -> {
            String string = this.startScreen.numberOfPlayers.getText();
            try {
                numPlayers = Integer.parseInt(string);
            } catch (Exception ignored) {}
        });

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
