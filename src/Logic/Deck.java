package Logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Deck extends ArrayList<Card> {
    public Deck() throws IllegalCard{
        super(52);
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 14; j++) {
                this.add(new Card(Card.Suit.values()[i], j));
            }
        }
    }

    public void shuffle() {
        Card[] temp = new Card[this.size()];
        int numCards = this.size();
        for(int i = 0; i < numCards; i++) {
            temp[i] = this.remove(new Random().nextInt(this.size()));
        }
        this.addAll(Arrays.asList(temp));
    }

    public void print() {
        for(Card card : this) {
            card.print();
        }
    }

    public Card drawCard() {
        return this.remove(0);
    }

    public void removeCard(Card card) {
        this.remove(card);
    }


}
