/**
 * Created by nicholaswebb on 1/29/16.
 */
public interface Poker {

    int increastAnte();
    Player compareHand();
    default public void fold(player x){

    }

    void dealHand(boolean x);

    void displayAllHand();

    void allBet();


}
