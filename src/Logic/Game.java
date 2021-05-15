package Logic;

import Exceptions.IllegalGame;


import java.util.ArrayList;

// S
public class Game {
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Player> activePlayers;
    private int dealerIndex = 0;

    public Game(int numPlayers) throws IllegalGame {
        this.players.add(new Player("Juan", 100));
        for(int i = 0; i < numPlayers - 1; i++) {
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

    private ArrayList<Player> updateActivePlayers(ArrayList<Player> allPlayers) {
        ArrayList<Player> players = new ArrayList<>();
        for (Player player:allPlayers) {
            if (!player.isSittingOut()) players.add(player);
        }
        return players;
    }

    public void setDealerIndex(int dealerIndex) {
        this.dealerIndex = dealerIndex;
    }

    public int getDealerIndex() {
        return dealerIndex;
    }

    private void newHand() {
        activePlayers = updateActivePlayers(players);
        Hand hand = new Hand(this);
        dealerIndex++;
        dealerIndex %= activePlayers.size();
    }

    public ArrayList<Player> getActivePlayers() {
        return activePlayers;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
