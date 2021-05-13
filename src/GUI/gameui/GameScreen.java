package GUI.gameui;

import GUI.gameui.gamescreenelements.MenuBar;
import GUI.gameui.gamescreenelements.OptionsBar;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;

public class GameScreen extends BorderPane {
    public GameScreen(){
        this.init();
    }

    private final MenuBar menuBar = new MenuBar();
    private final OptionsBar optionsBar = new OptionsBar();

    private void init(){
        this.setStyle("-fx-background-color: gray");
        menuBar.setAlignment(Pos.BASELINE_RIGHT);
        this.setTop(menuBar);


        optionsBar.setAlignment(Pos.BASELINE_LEFT);
        this.setBottom(optionsBar);
    }
}
