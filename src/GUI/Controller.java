package GUI;

import Exceptions.IllegalCard;
import Exceptions.IllegalGame;
import Logic.*;

public class Controller {
    public Controller() throws IllegalGame {
        Game game = new Game(3);
    }
}
