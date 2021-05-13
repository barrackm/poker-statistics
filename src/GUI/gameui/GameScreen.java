package GUI.gameui;

import GUI.gameui.gamescreenelements.MenuBar;
import GUI.gameui.gamescreenelements.OptionsBar;
import GUI.gameui.gamescreenelements.TableView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

public class GameScreen extends BorderPane {
    public GameScreen(){
        this.init();
    }

    public final MenuBar menuBar = new MenuBar();
    private final OptionsBar optionsBar = new OptionsBar();
    private final TableView tableView = new TableView();

    private void init(){
        this.setStyle("-fx-background-color: darkkhaki");
        menuBar.setAlignment(Pos.BASELINE_RIGHT);
        this.setTop(menuBar);


        optionsBar.setAlignment(Pos.BASELINE_LEFT);
        this.setBottom(optionsBar);

        this.setCenter(tableView);
    }
}
