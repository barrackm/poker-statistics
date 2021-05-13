package Logic;


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
        IllegalCard.validValue(value);
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

    public void print() {
        System.out.println(this.suit + " " + this.value);
    }
}
