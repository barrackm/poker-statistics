package GUI.gameui.gamescreenelements;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class OptionsBar extends HBox {

    public OptionsBar(){

        this.init();
    }

    public Button fold = new Button("Fold");
    public Button bet = new Button("Bet");
    public Button check = new Button("Check");
    public Button call = new Button("Call");
    public Label balance = new Label("   Balance...");

    private void init(){
        this.setStyle("-fx-background-color: gray");

        fold.setPrefSize(100, 50);
        bet.setPrefSize(100, 50);
        check.setPrefSize(100, 50);
        call.setPrefSize(100, 50);
        balance.setPrefSize(100, 50);

        this.getChildren().addAll(
                fold,
                bet,
                check,
                call,
                balance
        );
    }
}
