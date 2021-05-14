package Logic;

import Exceptions.IllegalGame;

import Exceptions.IllegalCard;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players = new ArrayList<>();
    private int dealerIndex = 0;

    public Game(int numPlayers) throws IllegalGame {
        for(int i = 0; i < numPlayers; i++) {
            this.players.add(new Player(this, 100));
        }
        if (numPlayers < 2 || numPlayers > 6) throw new IllegalGame("Invalid Number of Players");
        newHand();

    }

    public Game(ArrayList<Player> players) throws IllegalGame {
        this.players = players;
        if (players.size() < 2 || players.size() > 6) throw new IllegalGame("Invalid Number of Players");
    }

    public void addPlayer(Player player) throws IllegalGame {
        if (players.size() > 5) throw new IllegalGame("Invalid Number of Players");
        players.add(player);
    }

    public void removePlayer(Player player) throws IllegalGame {
        if (players.size() < 3) throw new IllegalGame("Invalid Number of Players");
        players.remove(player);
    }

    public void setDealerIndex(int dealerIndex) {
        this.dealerIndex = dealerIndex;
    }

    public int getDealerIndex() {
        return dealerIndex;
    }

    private void newHand() {
        Hand hand = new Hand(this);
        dealerIndex++;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
