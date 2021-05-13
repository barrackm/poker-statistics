package Logic;

import java.util.ArrayList;

public class Board {
    private Card[] communityCards = new Card[5];

    public Board(Deck deck) {
        for(int i = 0; i < 5; i++) {
            this.communityCards[i] = new Card(deck);
        }
    }

}
