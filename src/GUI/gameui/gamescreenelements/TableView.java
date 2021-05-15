package GUI.gameui.gamescreenelements;


import Logic.Card;
import Logic.Deck;
import Logic.Hole;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import javax.swing.*;
import java.io.FileInputStream;
import java.util.Arrays;

public class TableView extends Canvas {
    GraphicsContext g;

    private Hole hole;

    public TableView() {
        super(800, 300);
        this.init();
    }

    private void init() {
        g = this.getGraphicsContext2D();
        this.drawTable();
    }

    public void setCards(Hole hole){
        this.hole = hole;
    }

    private void drawTable(){
        // REMOVE:

        try{
            this.hole = new Hole(new Card(Card.Suit.SPADE, 13), new Card(Card.Suit.DIAMOND, 11), new Deck());
        } catch (Exception e){ e.printStackTrace();}

        // !

        // Table
        g.setFill(Color.GREEN);
        g.fillOval(0,
                50,
                this.getWidth(),
                this.getHeight() / 1.25
        );

        // Cards
        if (this.hole == null){
            System.out.println("is null");
            try{
                Image image = new Image(getClass().getResourceAsStream("resources/card back.png"));
                g.drawImage(image,
                        (this.getWidth() / 2),
                        this.getHeight() / 2,
                        this.getWidth() / 2 - 275,
                        (this.getHeight() / 2) + 10
                );
                g.drawImage(image,
                        (this.getWidth() / 2),
                        this.getHeight() / 2,
                        this.getWidth() / 2 - 525,
                        (this.getHeight() / 2) + 10
                );
            } catch(Exception e) {e.printStackTrace();}
        }
        else{
            // Get correct image path for suit
            String[] paths = new String[2];
            Arrays.fill(paths, "resources/");
            for (int i = 0; i < 2; ++i)
                switch (this.hole.getCards()[i].getSuit()){
                    case CLUB -> paths[i] += "clubs.png";
                    case HEART -> paths[i] += "hearts.png";
                    case SPADE -> paths[i] += "spades.png";
                    case DIAMOND -> paths[i] += "diamonds.jpg";
                }

            g.drawImage(new Image(getClass().getResourceAsStream(paths[0])),
                    (this.getWidth() / 2) + 10,
                    this.getHeight() / 2,
                    this.getWidth() / 2 - 275,
                    (this.getHeight() / 2) + 10
            );
            g.drawImage(new Image(getClass().getResourceAsStream(paths[1])),
                    (this.getWidth() / 2),
                    this.getHeight() / 2,
                    this.getWidth() / 2 - 525,
                    (this.getHeight() / 2) + 10
            );

            // Draw Card Value
            g.setFill(Color.BLACK);
            g.setFont(new Font("arial", 30));

            String[] vals = new String[2];

            // Switch for face cards
            for (int i = 0; i < 2; ++i){
                switch (this.hole.getCards()[i].getValue()){
                    case 11 -> vals[i] = "J";
                    case 12 -> vals[i] = "Q";
                    case 13 -> vals[i] = "K";
                    default -> vals[i] = String.valueOf(this.hole.getCards()[i].getValue());
                }
            }
            g.fillText(
                    vals[0],
                    500, 290
            );
            g.fillText(
                    vals[1],
                    360, 290
            );
        }

    }
}
