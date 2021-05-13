package Logic;

import java.util.ArrayList;

public class Table {
    private Card[] communityCards = new Card[5];

    public Table(Deck deck) {
        for(int i = 0; i < 5; i++) {
            this.communityCards[i] = new Card(deck);
        }
    }

}
