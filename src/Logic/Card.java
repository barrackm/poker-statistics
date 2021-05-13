package Logic;


import Exceptions.IllegalCard;

import java.util.Objects;

public class Card {
    private Suit suit;
    private int value;

    public Card(Deck deck) {
        Card drawCard = deck.drawCard();
        this.suit = drawCard.suit;
        this.value = drawCard.value;
    }

    public Card(Suit suit, int value) throws IllegalCard {
        this.suit = suit;
        this.value = value;
        if (value < 1 || value > 13) throw new IllegalCard("Invalid Value");
    }

    public enum Suit {
        SPADE,
        HEART,
        CLUB,
        DIAMOND
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return value == card.value && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, value);
    }

    @Override
    public String toString() {
        return this.suit + " " + this.value;
    }

    public void print() {
        System.out.println(this);
    }
}
