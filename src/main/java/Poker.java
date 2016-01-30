/**
 * Created by nicholaswebb on 1/29/16.
 */
public interface Poker {

    int increastAnte();
    Player compareHand();
    default public void fold(Hand hand){
        hand.deleteHand();

    }

    void dealHand(boolean x);

    void displayAllHand();

    void allBet();
    int rankHand();

}
