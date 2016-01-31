import org.junit.Test;
import static org.junit.Assert.*;

public class BlackJackTest {
    @Test
    public void dealAllSpec() {
        BlackJack game = new BlackJack();
        game.start();
        assertEquals("hands deal ", 3, game.getPlayerList().get(0).getHands().get(0).getHand().size());
        assertFalse("dealer ", game.getPlayerList().get(5).getHands().get(0).getHand().get(1).isFaceUp());

    }
}