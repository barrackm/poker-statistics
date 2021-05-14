package Logic;


import java.util.ArrayList;

public class Hand {
    private ArrayList<Player> players = new ArrayList<>();
    private Deck deck;
    private int numPlayers;
    private boolean headsUp = false;
    private double bigBlind = 10;
    private double pot = 0;
    private Table table;

    public Hand(Game game) {
        this.numPlayers = game.getPlayers().size();
        if (numPlayers == 2) headsUp = true;
        for(int i = 0; i < numPlayers; i++) {
            players.add(game.getPlayers().get((1 + i + game.getDealerIndex()) % numPlayers));
        }
        setBlinds();
        try {
            this.deck = new Deck();
            deck.shuffle();
        } catch (Exception ignored) {}
        dealHoles();
        this.table = new Table(deck);
        System.out.println(players);
        System.out.println(table);
        System.out.println("-----");
        System.out.println(HandRankings.determineWinner(table, players));
        System.out.println("-----");


        //System.out.println(pot);
    }

    private void setBlinds() {
        pot = 1.5 * bigBlind;
        for (Player player:players) {
            player.setBlind(0);
        }
        if (headsUp) {
            players.get(0).setBlind(bigBlind);
            players.get(0).betMoney(bigBlind);
            players.get(1).setBlind(0.5 * bigBlind);
            players.get(1).betMoney(0.5 * bigBlind);
        } else {
            players.get(0).setBlind(0.5 * bigBlind);
            players.get(0).betMoney(0.5 * bigBlind);
            players.get(1).setBlind(bigBlind);
            players.get(1).betMoney(bigBlind);
        }
    }

    private void dealHoles() {
        for (Player player:players) {
            try {
                player.setHole(new Hole(deck));
            } catch (Exception ignored) {}
        }
    }
}
