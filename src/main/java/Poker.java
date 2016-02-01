import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by rkelly on 1/31/16.
 */
public interface Poker {
    default int compareHands(ArrayList<Hand> hands) {
        ArrayList currentHandSorted = new ArrayList();

        for (Hand hand: hands){
            String royalFlush;
            String straightFlush;
            String fourOfAKind;
            String fullHouse;
            String flush;
            String straight;
            String threeOfAKind;
            String twoOFAKind;
            String twoPair;
            String onePair;
            String highCard;



        }
        /*
        handsOrder.add("royal flush");
        handsOrder.add("straight flush");
        handsOrder.add("4 of a kind");
        handsOrder.add("full house");
        handsOrder.add("flush");
        handsOrder.add("straight");
        handsOrder.add("3 of a kind");
        handsOrder.add("2 pair");
        handsOrder.add("1 pair");
        handsOrder.add("high card");
        */
        return 1;
    }


        int collectAnte();

        Player compareHand();

        void dealRound(boolean x);

        void displayHands();

        void allBet();

        default void fold(Player player) {
            player.getHands().get(0).getHand().clear();
        }
}
