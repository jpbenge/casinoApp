import com.sun.org.apache.bcel.internal.util.Class2HTML;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by johnb on 1/29/16.
 */
public class CardTest {

        @Test
        public void CardConstructorSpec() {
            Card c = new Card(Suit.HEARTS,5);
            assertNotNull("newly created card should not be null",c);
            assertEquals("card's suit should be HEARTS", Suit.HEARTS,c.getSuit());
            assertEquals("card's number be 5", 5,c.getNumber());
        }

        @Test
        public void CardFaceUpSpec() {
            Card c = new Card(Suit.CLUBS,10);
            assertTrue("card should be instantiated face up",c.isFaceUp());
            c.setFaceUp(false);
            assertFalse("card should now be face down",c.isFaceUp());
        }

        @Test
        public void CardDisplaySpec() {
            Card c1 = new Card(Suit.CLUBS,10);
            c1.display();
            Card c2 = new Card(Suit.HEARTS,11);
            c2.display();
            Card c3 = new Card(Suit.DIAMONDS,13);
            c3.display();
            Card c4 = new Card(Suit.SPADES,1);
            c4.display();
            c4.setFaceUp(false);
            c4.display();
        }
}
