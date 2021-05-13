package GUI.gameui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class StartScreen extends BorderPane {

    public StartScreen(){
        this.init();
    }

    public Button startGame = new Button("Start Game");
    public TextField numberOfPlayers = new TextField();

    private void init(){
        this.setStyle("-fx-background-color:gray");

        // Title:
        var tbox = new VBox();
        tbox.setAlignment(Pos.BOTTOM_CENTER);
        var title = new Text("POKER");
        title.setStyle("-fx-font: 60 arial");
        tbox.getChildren().add(title);

        this.setTop(tbox);

        // Start button & Number of players
        this.numberOfPlayers.setPromptText("Number of Players");

        var cbox = new HBox();
        cbox.setAlignment(Pos.CENTER);
        cbox.getChildren().addAll(
                startGame,
                numberOfPlayers
        );
        this.setCenter(cbox);

    }
}
