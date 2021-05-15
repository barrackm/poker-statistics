package Logic;


import java.util.ArrayList;

public class Hand {
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Player> playingPlayers;
    private Deck deck;
    private int numPlayers;
    private boolean headsUp = false;
    private double bigBlind = 10;
    private double pot = 0;
    private Table table;

    public Hand(Game game) {
        this.numPlayers = game.getActivePlayers().size();
        if (numPlayers == 2) headsUp = true;
        for(int i = 0; i < numPlayers; i++) {
            players.add(game.getActivePlayers().get((1 + i + game.getDealerIndex()) % numPlayers));
        }
        System.out.println(players);

        try {
            this.deck = new Deck();
            deck.shuffle();
        } catch (Exception ignored) {}

        dealHoles();

        this.table = new Table(deck);

        //System.out.println(players);
        //System.out.println(table);
        //System.out.println("-----");
        //System.out.println(HandRankings.determineWinner(table, players));
        //System.out.println("-----");
        playHand();
//

    }

    private void playHand() {
        playingPlayers = players;
        manageHand(true); //change back
        for (int i = 0; i < 3; i++) {
            if (playingPlayers.size() != 0) {
                manageHand(false);
            } else {
                break;
            }
        }
        ArrayList<Player> sortedWinners = HandRankings.determineWinner(table, playingPlayers);
        for (Player player : sortedWinners) {
            double notWon = 0;
            for (Player player2 : players) {
                if (player.getAtRiskMoney() < player2.getAtRiskMoney()) {
                    notWon += player2.getAtRiskMoney() - player.getAtRiskMoney();
                }
            }
            pot -= player.winMoney(pot - notWon);
            if (pot == 0) break;
            if (pot < 0) System.out.println("OOOOOOOF");
        }
    }

    private void manageHand(boolean firstRound) {
        int index = 0;
        int bettersIndex;
        int bigBlindIndex = 1;
        if (firstRound) {
            double hb;
            setBlinds();
            if (headsUp) {
                bigBlindIndex = 0;
                bettersIndex = 1;
                index = 0;
                hb = cycleThroughPlayers(bettersIndex, index, bigBlind, bigBlind);
            } else {
                bettersIndex = 1;
                index = 2;
                hb = cycleThroughPlayers(bettersIndex, index, bigBlind, bigBlind);
            }
            Player player = playingPlayers.get(bigBlindIndex);
            double bet = player.determineAction(pot, hb);
            if (bet != 0) {
                System.out.println("Raise " + bet);
                pot += bet;
                cycleThroughPlayers(bigBlindIndex, (bigBlindIndex + 1) % playingPlayers.size(), pot, player.getRoundBet());
            }
        } else {
            System.out.println("Check");
            bettersIndex = playingPlayers.size() - 1;
            cycleThroughPlayers(bettersIndex, index, pot, 0);
        }
        resetRoundBets();
    }

    private double cycleThroughPlayers(int bettersIndex, int index, double prevPot, double highestBet) {
        while (index != bettersIndex || prevPot != pot) {
            Player player = playingPlayers.get(index);
            double bet = player.determineAction(pot, highestBet);
            pot += bet;
            if (bet == 0 && highestBet != player.getRoundBet()) { //fold
                playingPlayers.remove(index);
                if (bettersIndex > index) {
                    bettersIndex--;
                    index--; //idk about this
                }
                System.out.println("Fold");
            } else if (highestBet == player.getRoundBet()) { //call/
                if (bet == 0) System.out.println("Check");
                else System.out.println("Call " + bet);
            } else if (player.getRoundBet() > highestBet) {
                bettersIndex = index;
                highestBet = player.getRoundBet();
                System.out.println("Raise " + bet);
            }
            index = (index + 1) % playingPlayers.size();
            prevPot = pot;
        }
        return highestBet;
    }

    private void resetRoundBets() {
        for (Player player : players) {
            player.setRoundBet(0);
        }
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
