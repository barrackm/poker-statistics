package Logic;

import Exceptions.IllegalCard;

public class Hole {
    private Card[] cards = new Card[2];

    public Hole(Deck deck) {
        cards[0] = new Card(deck);
        cards[1] = new Card(deck);
    }


    public Hole(Card card1, Card card2, Deck deck) {
        cards[0] = card1;
        cards[1] = card2;
        deck.removeCard(card1);
        deck.removeCard(card2);
    }

    public Card[] getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return cards[0].toString() + " " + cards[1].toString();
    }

    public void print() {
        System.out.println(this.toString());
    }
}
