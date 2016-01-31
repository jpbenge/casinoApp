import org.junit.Test;
import static org.junit.Assert.*;

public class BlackJackTest {
    @Test
    public void checkTotalSpec() {
        BlackJack game = new BlackJack();
        Player p1 = new Player();
        p1.getHands().add(new Hand());
        p1.getHands().get(0).addCard(new Card(Suit.HEARTS,10));
        p1.getHands().get(0).addCard(new Card(Suit.SPADES,10));
        p1.getHands().get(0).addCard(new Card(Suit.DIAMONDS,1));
        assertEquals("P1's total should be 21",21,game.checkTotal(p1));
        Player p2 = new Player();
        p2.getHands().add(new Hand());
        p2.getHands().get(0).addCard(new Card(Suit.HEARTS,10));
        p2.getHands().get(0).addCard(new Card(Suit.SPADES,1));
        assertEquals("p2's total should be 21",21,game.checkTotal(p2));
        Player p3 = new Player();
        p3.getHands().add(new Hand());
        p3.getHands().get(0).addCard(new Card(Suit.HEARTS,10));
        p3.getHands().get(0).addCard(new Card(Suit.SPADES,1));
        p3.getHands().get(0).addCard(new Card(Suit.DIAMONDS,1));
        assertEquals("p3's total should be 12",12,game.checkTotal(p3));
        Player p4 = new Player();
        p4.getHands().add(new Hand());
        p4.getHands().get(0).addCard(new Card(Suit.HEARTS,6));
        p4.getHands().get(0).addCard(new Card(Suit.SPADES,1));
        p4.getHands().get(0).addCard(new Card(Suit.DIAMONDS,1));
        assertEquals("p4's total should be 18",18,game.checkTotal(p4));
    }
}