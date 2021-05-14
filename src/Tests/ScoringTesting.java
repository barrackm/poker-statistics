package Tests;
import static org.junit.jupiter.api.Assertions.*;

import Logic.Card;
import Logic.HandRankings;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.ArrayList;

class ScoringTesting {
    @Test
    public void highCardTest1() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.SPADE, 1));
        assertEquals(Double.parseDouble(new DecimalFormat("#.0000000000").format(HandRankings.determineHand(cards))), 0.14);
    }

    @Test
    public void highCardTest2() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.SPADE, 13));
        cards.add(new Card(Card.Suit.DIAMOND, 4));
        assertEquals(Double.parseDouble(new DecimalFormat("#.0000000000").format(HandRankings.determineHand(cards))), 0.1304);
    }

    @Test
    public void highCardTest3() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.SPADE, 1));
        cards.add(new Card(Card.Suit.HEART, 8));
        cards.add(new Card(Card.Suit.DIAMOND, 13));
        assertEquals(Double.parseDouble(new DecimalFormat("#.0000000000").format(HandRankings.determineHand(cards))), 0.141308);
    }

    @Test
    public void highCardTest4() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.SPADE, 4));
        cards.add(new Card(Card.Suit.HEART, 9));
        cards.add(new Card(Card.Suit.DIAMOND, 2));
        cards.add(new Card(Card.Suit.SPADE, 10));
        assertEquals(Double.parseDouble(new DecimalFormat("#.0000000000").format(HandRankings.determineHand(cards))), 0.10090402);
    }

    @Test
    public void highCardTest5() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.SPADE, 4));
        cards.add(new Card(Card.Suit.HEART, 9));
        cards.add(new Card(Card.Suit.DIAMOND, 2));
        cards.add(new Card(Card.Suit.SPADE, 10));
        cards.add(new Card(Card.Suit.SPADE, 1));
        assertEquals(Double.parseDouble(new DecimalFormat("#.0000000000").format(HandRankings.determineHand(cards))), 0.1410090402);
    }

    @Test
    public void pairTest1() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.SPADE, 1));
        cards.add(new Card(Card.Suit.CLUB, 1));
        assertEquals(Double.parseDouble(new DecimalFormat("#.0000000000").format(HandRankings.determineHand(cards))), 1.14);
    }

    @Test
    public void pairTest2() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.SPADE, 5));
        cards.add(new Card(Card.Suit.DIAMOND, 5));
        cards.add(new Card(Card.Suit.DIAMOND, 6));
        assertEquals(Double.parseDouble(new DecimalFormat("#.0000000000").format(HandRankings.determineHand(cards))), 1.0506);
    }

    @Test
    public void pairTest3() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.SPADE, 5));
        cards.add(new Card(Card.Suit.DIAMOND, 5));
        cards.add(new Card(Card.Suit.DIAMOND, 6));
        cards.add(new Card(Card.Suit.HEART, 1));
        assertEquals(Double.parseDouble(new DecimalFormat("#.0000000000").format(HandRankings.determineHand(cards))), 1.051406);
    }

    @Test
    public void pairTest4() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.SPADE, 2));
        cards.add(new Card(Card.Suit.DIAMOND, 5));
        cards.add(new Card(Card.Suit.DIAMOND, 6));
        cards.add(new Card(Card.Suit.HEART, 9));
        cards.add(new Card(Card.Suit.CLUB, 9));
        assertEquals(Double.parseDouble(new DecimalFormat("#.0000000000").format(HandRankings.determineHand(cards))), 1.09060502);
    }

    @Test
    public void pairTest5() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.SPADE, 2));
        cards.add(new Card(Card.Suit.DIAMOND, 5));
        cards.add(new Card(Card.Suit.DIAMOND, 6));
        cards.add(new Card(Card.Suit.HEART, 9));
        cards.add(new Card(Card.Suit.CLUB, 9));
        cards.add(new Card(Card.Suit.DIAMOND, 1));
        cards.add(new Card(Card.Suit.HEART, 4));
        cards.add(new Card(Card.Suit.CLUB, 11));
        assertEquals(Double.parseDouble(new DecimalFormat("#.0000000000").format(HandRankings.determineHand(cards))), 1.09141106);
    }

    @Test
    public void twoPairTest1() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.SPADE, 5));
        cards.add(new Card(Card.Suit.DIAMOND, 5));
        cards.add(new Card(Card.Suit.DIAMOND, 6));
        cards.add(new Card(Card.Suit.HEART, 6));
        assertEquals(Double.parseDouble(new DecimalFormat("#.0000000000").format(HandRankings.determineHand(cards))), 2.0605);
    }

    @Test
    public void twoPairTest2() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.SPADE, 2));
        cards.add(new Card(Card.Suit.DIAMOND, 2));
        cards.add(new Card(Card.Suit.DIAMOND, 6));
        cards.add(new Card(Card.Suit.HEART, 9));
        cards.add(new Card(Card.Suit.CLUB, 9));
        assertEquals(Double.parseDouble(new DecimalFormat("#.0000000000").format(HandRankings.determineHand(cards))), 2.090206);
    }

    @Test
    public void twoPairTest3() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.SPADE, 6));
        cards.add(new Card(Card.Suit.DIAMOND, 2));
        cards.add(new Card(Card.Suit.DIAMOND, 6));
        cards.add(new Card(Card.Suit.HEART, 11));
        cards.add(new Card(Card.Suit.CLUB, 11));
        cards.add(new Card(Card.Suit.HEART, 8));
        cards.add(new Card(Card.Suit.CLUB, 13));
        assertEquals(Double.parseDouble(new DecimalFormat("#.0000000000").format(HandRankings.determineHand(cards))), 2.110613);
    }

    @Test
    public void threeOfKindTest1() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.SPADE, 1));
        cards.add(new Card(Card.Suit.CLUB, 1));
        cards.add(new Card(Card.Suit.DIAMOND, 1));
        assertEquals(Double.parseDouble(new DecimalFormat("#.0000000000").format(HandRankings.determineHand(cards))), 3.14);
    }

    @Test
    public void threeOfKindTest2() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.SPADE, 1));
        cards.add(new Card(Card.Suit.CLUB, 1));
        cards.add(new Card(Card.Suit.DIAMOND, 1));
        cards.add(new Card(Card.Suit.SPADE, 2));
        assertEquals(Double.parseDouble(new DecimalFormat("#.0000000000").format(HandRankings.determineHand(cards))), 3.1402);
    }

    @Test
    public void threeOfKindTest3() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.SPADE, 1));
        cards.add(new Card(Card.Suit.CLUB, 2));
        cards.add(new Card(Card.Suit.DIAMOND, 2));
        cards.add(new Card(Card.Suit.SPADE, 2));
        cards.add(new Card(Card.Suit.DIAMOND, 5));
        cards.add(new Card(Card.Suit.DIAMOND, 6));
        assertEquals(Double.parseDouble(new DecimalFormat("#.0000000000").format(HandRankings.determineHand(cards))), 3.021406);
    }

    @Test
    public void straightTest1() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.SPADE, 1));
        cards.add(new Card(Card.Suit.CLUB, 2));
        cards.add(new Card(Card.Suit.DIAMOND, 3));
        cards.add(new Card(Card.Suit.SPADE, 4));
        cards.add(new Card(Card.Suit.DIAMOND, 5));
        assertEquals(Double.parseDouble(new DecimalFormat("#.0000000000").format(HandRankings.determineHand(cards))), 4.05);
    }

    @Test
    public void straightTest2() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.CLUB, 2));
        cards.add(new Card(Card.Suit.DIAMOND, 3));
        cards.add(new Card(Card.Suit.SPADE, 4));
        cards.add(new Card(Card.Suit.DIAMOND, 5));
        cards.add(new Card(Card.Suit.DIAMOND, 6));
        assertEquals(Double.parseDouble(new DecimalFormat("#.0000000000").format(HandRankings.determineHand(cards))), 4.06);
    }

    @Test
    public void straightTest3() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.DIAMOND, 11));
        cards.add(new Card(Card.Suit.CLUB, 10));
        cards.add(new Card(Card.Suit.SPADE, 12));
        cards.add(new Card(Card.Suit.DIAMOND, 1));
        cards.add(new Card(Card.Suit.DIAMOND, 13));
        assertEquals(Double.parseDouble(new DecimalFormat("#.0000000000").format(HandRankings.determineHand(cards))), 4.14);
    }

    @Test
    public void straightTest4() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.SPADE, 1));
        cards.add(new Card(Card.Suit.CLUB, 2));
        cards.add(new Card(Card.Suit.DIAMOND, 3));
        cards.add(new Card(Card.Suit.SPADE, 4));
        cards.add(new Card(Card.Suit.DIAMOND, 5));
        cards.add(new Card(Card.Suit.CLUB, 10));
        cards.add(new Card(Card.Suit.SPADE, 12));
        assertEquals(Double.parseDouble(new DecimalFormat("#.0000000000").format(HandRankings.determineHand(cards))), 4.05);
    }

    @Test
    public void straightTest5() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.CLUB, 2));
        cards.add(new Card(Card.Suit.DIAMOND, 3));
        cards.add(new Card(Card.Suit.SPADE, 4));
        cards.add(new Card(Card.Suit.DIAMOND, 5));
        cards.add(new Card(Card.Suit.DIAMOND, 6));
        cards.add(new Card(Card.Suit.SPADE, 4));
        cards.add(new Card(Card.Suit.DIAMOND, 5));
        assertEquals(Double.parseDouble(new DecimalFormat("#.0000000000").format(HandRankings.determineHand(cards))), 4.06);
    }

    @Test
    public void straightTest6() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.DIAMOND, 11));
        cards.add(new Card(Card.Suit.CLUB, 10));
        cards.add(new Card(Card.Suit.SPADE, 12));
        cards.add(new Card(Card.Suit.DIAMOND, 1));
        cards.add(new Card(Card.Suit.DIAMOND, 13));
        cards.add(new Card(Card.Suit.SPADE, 4));
        cards.add(new Card(Card.Suit.DIAMOND, 5));
        assertEquals(Double.parseDouble(new DecimalFormat("#.0000000000").format(HandRankings.determineHand(cards))), 4.14);
    }

    @Test
    public void flushTest1() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.SPADE, 4));
        cards.add(new Card(Card.Suit.SPADE, 2));
        cards.add(new Card(Card.Suit.SPADE, 9));
        cards.add(new Card(Card.Suit.SPADE, 6));
        cards.add(new Card(Card.Suit.SPADE, 5));
        assertEquals(Double.parseDouble(new DecimalFormat("#.0000000000").format(HandRankings.determineHand(cards))), 5.0906050402);
    }

    @Test
    public void flushTest2() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.CLUB, 4));
        cards.add(new Card(Card.Suit.CLUB, 2));
        cards.add(new Card(Card.Suit.CLUB, 4));
        cards.add(new Card(Card.Suit.CLUB, 1));
        cards.add(new Card(Card.Suit.CLUB, 5));
        assertEquals(Double.parseDouble(new DecimalFormat("#.0000000000").format(HandRankings.determineHand(cards))), 5.1405040402);
    }

    @Test
    public void flushTest3() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.DIAMOND, 4));
        cards.add(new Card(Card.Suit.DIAMOND, 4));
        cards.add(new Card(Card.Suit.DIAMOND, 4));
        cards.add(new Card(Card.Suit.DIAMOND, 1));
        cards.add(new Card(Card.Suit.DIAMOND, 5));
        assertEquals(Double.parseDouble(new DecimalFormat("#.0000000000").format(HandRankings.determineHand(cards))), 5.1405040404);
    }

    @Test
    public void flushTest4() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.HEART, 7));
        cards.add(new Card(Card.Suit.HEART, 5));
        cards.add(new Card(Card.Suit.HEART, 4));
        cards.add(new Card(Card.Suit.HEART, 1));
        cards.add(new Card(Card.Suit.HEART, 5));
        cards.add(new Card(Card.Suit.DIAMOND, 9));
        cards.add(new Card(Card.Suit.DIAMOND, 11));
        cards.add(new Card(Card.Suit.DIAMOND, 1));
        assertEquals(Double.parseDouble(new DecimalFormat("#.0000000000").format(HandRankings.determineHand(cards))), 5.1407050504);
    }

    @Test
    public void fullHouseTest1() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.HEART, 4));
        cards.add(new Card(Card.Suit.DIAMOND, 4));
        cards.add(new Card(Card.Suit.CLUB, 4));
        cards.add(new Card(Card.Suit.HEART, 1));
        cards.add(new Card(Card.Suit.HEART, 5));
        cards.add(new Card(Card.Suit.SPADE, 9));
        cards.add(new Card(Card.Suit.HEART, 11));
        cards.add(new Card(Card.Suit.DIAMOND, 1));
        assertEquals(Double.parseDouble(new DecimalFormat("#.0000000000").format(HandRankings.determineHand(cards))), 6.0414);
    }

    @Test
    public void fullHouseTest2() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.HEART, 1));
        cards.add(new Card(Card.Suit.DIAMOND, 1));
        cards.add(new Card(Card.Suit.CLUB, 1));
        cards.add(new Card(Card.Suit.HEART, 6));
        cards.add(new Card(Card.Suit.DIAMOND, 6));
        assertEquals(Double.parseDouble(new DecimalFormat("#.0000000000").format(HandRankings.determineHand(cards))), 6.1406);
    }

    @Test
    public void fourOfKindTest1() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.HEART, 1));
        cards.add(new Card(Card.Suit.DIAMOND, 1));
        cards.add(new Card(Card.Suit.CLUB, 1));
        cards.add(new Card(Card.Suit.SPADE, 1));
        cards.add(new Card(Card.Suit.DIAMOND, 6));
        assertEquals(Double.parseDouble(new DecimalFormat("#.0000000000").format(HandRankings.determineHand(cards))), 7.1406);
    }

    @Test
    public void fourOfKindTest2() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.HEART, 8));
        cards.add(new Card(Card.Suit.DIAMOND, 2));
        cards.add(new Card(Card.Suit.CLUB, 8));
        cards.add(new Card(Card.Suit.SPADE, 8));
        cards.add(new Card(Card.Suit.DIAMOND, 8));
        assertEquals(Double.parseDouble(new DecimalFormat("#.0000000000").format(HandRankings.determineHand(cards))), 7.0802);
    }

    @Test
    public void fourOfKindTest3() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.HEART, 8));
        cards.add(new Card(Card.Suit.DIAMOND, 2));
        cards.add(new Card(Card.Suit.CLUB, 8));
        cards.add(new Card(Card.Suit.SPADE, 8));
        cards.add(new Card(Card.Suit.DIAMOND, 8));
        cards.add(new Card(Card.Suit.SPADE, 9));
        cards.add(new Card(Card.Suit.DIAMOND, 9));
        assertEquals(Double.parseDouble(new DecimalFormat("#.0000000000").format(HandRankings.determineHand(cards))), 7.0809);
    }

    @Test
    public void straightFlushTest1() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.HEART, 2));
        cards.add(new Card(Card.Suit.HEART, 5));
        cards.add(new Card(Card.Suit.HEART, 4));
        cards.add(new Card(Card.Suit.HEART, 1));
        cards.add(new Card(Card.Suit.HEART, 3));
        assertEquals(Double.parseDouble(new DecimalFormat("#.0000000000").format(HandRankings.determineHand(cards))), 8.05);
    }

    @Test
    public void straightFlushTest2() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.HEART, 2));
        cards.add(new Card(Card.Suit.HEART, 5));
        cards.add(new Card(Card.Suit.HEART, 4));
        cards.add(new Card(Card.Suit.HEART, 1));
        cards.add(new Card(Card.Suit.HEART, 3));
        cards.add(new Card(Card.Suit.DIAMOND, 6));
        cards.add(new Card(Card.Suit.DIAMOND, 11));
        cards.add(new Card(Card.Suit.DIAMOND, 1));
        assertEquals(Double.parseDouble(new DecimalFormat("#.0000000000").format(HandRankings.determineHand(cards))), 8.05);
    }

    @Test
    public void straightFlushTest3() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.HEART, 2));
        cards.add(new Card(Card.Suit.HEART, 5));
        cards.add(new Card(Card.Suit.HEART, 4));
        cards.add(new Card(Card.Suit.HEART, 6));
        cards.add(new Card(Card.Suit.HEART, 3));
        cards.add(new Card(Card.Suit.DIAMOND, 6));
        cards.add(new Card(Card.Suit.DIAMOND, 11));
        cards.add(new Card(Card.Suit.DIAMOND, 1));
        assertEquals(Double.parseDouble(new DecimalFormat("#.0000000000").format(HandRankings.determineHand(cards))), 8.06);
    }

    @Test
    public void straightFlushTest4() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.HEART, 10));
        cards.add(new Card(Card.Suit.HEART, 11));
        cards.add(new Card(Card.Suit.HEART, 12));
        cards.add(new Card(Card.Suit.HEART, 13));
        cards.add(new Card(Card.Suit.HEART, 1));
        cards.add(new Card(Card.Suit.DIAMOND, 1));
        cards.add(new Card(Card.Suit.CLUB, 1));
        cards.add(new Card(Card.Suit.DIAMOND, 13));
        assertEquals(Double.parseDouble(new DecimalFormat("#.0000000000").format(HandRankings.determineHand(cards))), 8.14);
    }

    @Test
    public void straightFlushTest5() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.HEART, 10));
        cards.add(new Card(Card.Suit.HEART, 11));
        cards.add(new Card(Card.Suit.HEART, 12));
        cards.add(new Card(Card.Suit.HEART, 13));
        cards.add(new Card(Card.Suit.HEART, 9));
        cards.add(new Card(Card.Suit.DIAMOND, 1));
        cards.add(new Card(Card.Suit.CLUB, 1));
        cards.add(new Card(Card.Suit.DIAMOND, 13));
        assertEquals(Double.parseDouble(new DecimalFormat("#.0000000000").format(HandRankings.determineHand(cards))), 8.13);
    }
}

