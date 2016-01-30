import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by johnb on 1/29/16.
 */
public class HandTest {

    @Test
    public void testHandAddRemoveCard()
    {
        Hand h = new Hand();
        assertNotNull("newly created hand should not be null",h);
        assertEquals("newly created h.hand's size should be 0",0,h.getHand().size());
        h.addCard(new Card(Suit.DIAMONDS,7));
        assertEquals("h's hand should now have a size of 1",1,h.getHand().size());
        assertEquals("first card in hand's suit should be DIAMONDS", Suit.DIAMONDS,h.getHand().get(0).getSuit());
        assertEquals("first card in hand's number should be 7", 7,h.getHand().get(0).getNumber());
    }

    @Test
    public void testDisplayHandTest()
    {
        Hand h = new Hand();
        h.addCard(new Card(Suit.DIAMONDS,7));
        h.display();
        h.addCard(new Card(Suit.HEARTS,12));
        h.addCard(new Card(Suit.SPADES,1));
        h.addCard(new Card(Suit.CLUBS,10));
        h.addCard(new Card(Suit.SPADES,4));
        h.display();
    }
}
