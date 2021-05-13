package Logic;


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

    public void print() {
        System.out.println(this.suit + " " + this.value);
    }
}
