import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by johnb on 1/29/16.
 */
public class DeckTest {

    @Test
    public void deckConstructorSpec() {
        Deck deck = new Deck();
        assertNotNull("newly created deck should not be null",deck);
        assertEquals("newly created deck's size should be 52",52,deck.size());
        assertEquals("newly created deck's 51th element should have a suit of SPADES",Suit.SPADES,deck.get(51).getSuit());
        assertEquals("newly created deck's 51th element should have a number of 13",13,deck.get(51).getNumber());
        deck.remove(51);
        assertEquals("deck's size should now be 51",51,deck.size());
    }

    @Test
    public void deckOverloadedConstructorSpec() {
        Deck deck = new Deck(3);
        assertEquals("triple deck's size should be 156",156,deck.size());
        assertEquals("triple deck's 104th element's suit should be CLUBS", Suit.CLUBS,deck.get(104).getSuit());
        assertEquals("triple deck's 104th element's number should be 1", 1,deck.get(104).getNumber());
    }
}
