import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by johnb on 1/31/16.
 */
public class FiveCardStudTest {

    @Test

    public void collectAnteSpec() {
        PlayerManager pm = new PlayerManager();
        FiveCardStud fiveCard = new FiveCardStud();
        pm.loadPlayer();
        fiveCard.initPlayers();
        assertEquals("Ante should be 120  ",120, fiveCard.collectAnte());
    }


}
