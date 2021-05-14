package Logic;

import java.util.ArrayList;
import java.util.Arrays;

public class Table {
    private Card[] communityCards = new Card[5];

    public Table(Deck deck) {
        for(int i = 0; i < 5; i++) {
            this.communityCards[i] = new Card(deck);
        }
    }

    public Table(Deck deck, Card[] cards) {
        this.communityCards = cards;
    }

    public Card[] getCommunityCards() {
        return communityCards;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < communityCards.length; i++) {
            s += communityCards[i].toString() + " ";
        }
        return s;
    }

}
