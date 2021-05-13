package GUI;

import Exceptions.IllegalCard;
import Logic.*;

public class Controller {
    public Controller() throws IllegalCard {
        Game game = new Game(3);
        System.out.println(game.getPlayers());
    }
}
