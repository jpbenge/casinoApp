import java.util.Collections;

/**
 * Created by johnb on 1/31/16.
 */
public interface Poker{

    int collectAnte();

    Player compareHand();

    void dealRound(boolean x);

    void displayHands();

    void allBet();

    default void fold(Player player) {
        player.getHands().get(0).getHand().clear();
    }

}
