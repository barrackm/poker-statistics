package Logic;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HandRankings {
    public static final int HIGHCARD = 0;
    public static final int PAIR = 1;
    public static final int TWOPAIR = 2;
    public static final int THREEKIND = 3;
    public static final int STRAIGHT = 4;
    public static final int FLUSH = 5;
    public static final int FULLHOUSE = 6;
    public static final int FOURKIND = 7;
    public static final int STRAIGHTFLUSH = 8;

    public static ArrayList<Player> determineWinner(Table table, ArrayList<Player> players) {
        for(Player player : players) {
            ArrayList<Card> cards = new ArrayList<>();
            for(int i = 0; i < player.getHole().getCards().length; i++) {
                cards.add(player.getHole().getCards()[i]);
            }
            for(int i = 0; i < table.getCommunityCards().length; i++) {
                cards.add(table.getCommunityCards()[i]);
            }
            System.out.println(player.name);
            player.setHandScore(Double.parseDouble(new DecimalFormat("#.0000000000").format(determineHand(cards))));
            System.out.println(player.getHandScore());
        }

        System.out.println(players);

        ArrayList<Player> sortedPlayers = players;
        Collections.sort(sortedPlayers);

        return sortedPlayers;
    }

    public static double determineHand(ArrayList<Card> cards) {
        ArrayList<Card> spades = new ArrayList<>();
        ArrayList<Card> hearts = new ArrayList<>();
        ArrayList<Card> clubs = new ArrayList<>();
        ArrayList<Card> diamonds = new ArrayList<>();

        int[] frequencies = new int[13];
        Arrays.fill(frequencies, 0);
        Collections.sort(cards);
        System.out.println(cards);

        boolean pair = false;
        boolean threeOf = false;
        boolean twoPair = false;
        int setValue = 0;
        int firstPairValue = 0;
        int secondPairValue = 0;
        //Testing for flush or straight and adding to frequency array
        for (Card value : cards) {
            switch (value.getSuit()) {
                case SPADE -> spades.add(value);
                case HEART -> hearts.add(value);
                case CLUB -> clubs.add(value);
                case DIAMOND -> diamonds.add(value);
            }
            frequencies[value.getValue() - 1]++;
        }

        if (spades.size() >= 5) {
            if (isStraight(spades)) {
                return STRAIGHTFLUSH + highestOfStraight(spades) / 100.;
            } else
                return FLUSH + scoreOrdered5Cards(spades);
        }

        if (hearts.size() >= 5) {
            if (isStraight(hearts)) {
                return STRAIGHTFLUSH + highestOfStraight(hearts) / 100.;
            } else
                return FLUSH + scoreOrdered5Cards(hearts);
        }

        if (clubs.size() >= 5) {
            if (isStraight(clubs)) {
                return STRAIGHTFLUSH + highestOfStraight(clubs) / 100.;
            } else
                return FLUSH + scoreOrdered5Cards(clubs);
        }

        if (diamonds.size() >= 5) {
            if (isStraight(diamonds)) {
                return STRAIGHTFLUSH + highestOfStraight(diamonds) / 100.;
            } else
                return FLUSH + scoreOrdered5Cards(diamonds);
        }

        for (int i = 0; i < 13; i++) {
            if (frequencies[i] == 4) {
                if (i == 0) {
                    return FOURKIND + 14 / 100. + highestRemainingCard(cards, i + 1) / 10000.;
                }
                return FOURKIND + (i + 1) / 100. + highestRemainingCard(cards, i + 1) / 10000.;
            }

            if (frequencies[i] == 3) {
                threeOf = true;
                setValue = i + 1;
            }

            if (frequencies[i] == 2 && pair) {
                twoPair = true;
                if (i + 1 > firstPairValue) {
                    secondPairValue = firstPairValue;
                    firstPairValue = i + 1;
                } else {
                    secondPairValue = i + 1;
                }
            }

            if (frequencies[i] == 2 && !pair) {
                pair = true;
                if (i == 0) {
                    firstPairValue = 14;
                } else {
                    firstPairValue = i + 1;
                }
            }
        }

        if (pair && threeOf) {
            if (setValue == 1) setValue = 14;
            return FULLHOUSE + setValue / 100. + firstPairValue / 10000.;
        }
        if (isStraight(cards)) return STRAIGHT + highestOfStraight(cards) / 100.;
        if (threeOf) {
            ArrayList<Card> remainingCards = new ArrayList<>();
            for (Card card : cards) {
                if (card.getValue() != setValue) remainingCards.add(card);
            }

            if (setValue == 1) setValue = 14;

            if (cards.size() >= 5) {
                return THREEKIND + setValue / 100. + scoreOrderedNCards(remainingCards, 2) / 100.;
            } else {
                return THREEKIND + setValue / 100. + scoreOrderedNCards(remainingCards, cards.size() - 3) / 100.;
            }
        }
        if (twoPair) {
            ArrayList<Card> remainingCards = new ArrayList<>();
            int highestValue;
            if (firstPairValue == 14) {
                highestValue = 14;
                firstPairValue = 1;
            } else {
                highestValue = firstPairValue;
            }

            for (Card card : cards) {
                if (card.getValue() != firstPairValue && card.getValue() != secondPairValue) remainingCards.add(card);
            }

            if (cards.size() >= 5) {
                return TWOPAIR + highestValue / 100. + secondPairValue / 10000. + scoreOrderedNCards(remainingCards, 1) / 10000.;
            } else {
                return TWOPAIR + highestValue / 100. + secondPairValue / 10000.;
            }
        }
        if (pair) {
            ArrayList<Card> remainingCards = new ArrayList<>();
            for (Card card : cards) {
                if (card.getValue() != firstPairValue) remainingCards.add(card);
            }

            if (cards.size() >= 5) {
                return PAIR + firstPairValue / 100. + scoreOrderedNCards(remainingCards, 3) / 100.;
            } else {
                return PAIR + firstPairValue / 100. + scoreOrderedNCards(remainingCards, cards.size() - 2) / 100.;
            }
        }
        return HIGHCARD + noHandScore(frequencies);
    }

    private static boolean isStraight(ArrayList<Card> cards) {
        int[] frequencies = new int[13];
        Arrays.fill(frequencies,0);
        for (Card card : cards) {
            frequencies[card.getValue() - 1]++;
        }

        if (frequencies[0] > 0 && frequencies[9] > 0 && frequencies[10] > 0
                && frequencies[11] > 0 && frequencies[12] > 0) return true;
        for (int i = 0; i < 9; i++) {
            if (frequencies[i] > 0 && frequencies[i + 1] > 0 && frequencies[i + 2] > 0
                    && frequencies[i + 3] > 0 && frequencies[i + 4] > 0) return true;
        }
        return false;
    }

    private static int highestOfStraight(ArrayList<Card> cards) {
        int[] frequencies = new int[13];
        Arrays.fill(frequencies,0);
        for (Card card : cards) {
            frequencies[card.getValue() - 1]++;
        }

        if (frequencies[0] > 0 && frequencies[9] > 0 && frequencies[10] > 0
                && frequencies[11] > 0 && frequencies[12] > 0) return 14;
        for (int i = 0; i < 9; i++) {
            if (frequencies[i] > 0 && frequencies[i + 1] > 0 && frequencies[i + 2] > 0
                    && frequencies[i + 3] > 0 && frequencies[i + 4] > 0) return i + 5;
        }
        return 0;
    }

    private static int highestRemainingCard(ArrayList<Card> cards, int exclusionValue) { // exclusion value is card value to be ignored when finding next highest
        int value = 0;
        for (Card card : cards) {
            if (card.getValue() != exclusionValue) {
                if (card.getValue() == 1) return  14;
                else if (card.getValue() > value) {
                    value = card.getValue();
                }
            }
        }
        return value;
    }

    private static double noHandScore(int[] frequencies) {
        double score = 0;
        int numCardsCounted = 0;

        for(int i = 13; i > 0; i--) {
            if (i == 13) {
                for (int j = 0; j < frequencies[0]; j++) {
                    numCardsCounted++;
                    score += 14 / Math.pow(100, numCardsCounted);
                    if (numCardsCounted == 5) return score;
                }
            } else {
                for (int j = 0; j < frequencies[i]; j++) {
                    numCardsCounted++;
                    score += (i + 1) / Math.pow(100, numCardsCounted);
                    if (numCardsCounted == 5) return score;
                }
            }
        }
        return score;
    }

    private static double scoreOrdered5Cards(ArrayList<Card> cards) {
        double score = 0;
        for (int i = 0; i < 5; i++) {
            if (cards.get(i).getValue() == 1) {
                score += 14 / Math.pow(100, i + 1);
            } else {
                score += cards.get(i).getValue() / Math.pow(100, i + 1);
            }
        }
        return score;
    }

    private static double scoreOrderedNCards(ArrayList<Card> cards, int numberOfCards) {
        double score = 0;
        for (int i = 0; i < numberOfCards; i++) {
            if (cards.get(i).getValue() == 1) {
                score += 14 / Math.pow(100, i + 1);
            } else {
                score += cards.get(i).getValue() / Math.pow(100, i + 1);
            }
        }
        return score;
    }
}
