package Logic;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players = new ArrayList<>();

    public Game(int numPlayers) {
        for(int i = 0; i < numPlayers; i++) {
            this.players.add(new Player(this));
        }
    }

    public Game(ArrayList<Player> players) throws IllegalCard {
        this.players = players;
        if (players.size() < 2 || players.size() > 6) throw new IllegalCard("Invalid Number of Players");
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
