package GUI.gameui.gamescreenelements;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class TableView extends Canvas {
    GraphicsContext g;

    public TableView() {
        super(800, 300);
        this.init();
    }

    private void init() {
        g = this.getGraphicsContext2D();
        this.drawTable();
    }



    private void drawTable(){

        g.setFill(Color.GREEN);
        g.fillOval(0,
                50,
                this.getWidth(),
                this.getHeight() / 1.25
                );
    }
}
