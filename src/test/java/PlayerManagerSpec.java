import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerManagerSpec {
    @Test

    public void loadPlayerTest() {
        PlayerManager player1 = new PlayerManager();
        assertEquals("Player name is : ","Peter",player1.loadPlayer());
    }

}
