/**
 * Created by johnb on 1/30/16.
 */
public class BlackJack {

    private int numOfDecks = 3;
    private boolean busted = false;
    int numChips = 1000;

    private void start() {
        Deck deck = new Deck(3);
        deck.shuffle();
    }

    private void placeBet() {
        System.out.println();
    }

    private void dealAll(boolean b) {

    }

    private boolean compareHand() {
        return true;
    }

    private void hit() {

    }

    private void stay() {

    }

    private void doubleDown() {

    }

    private void split() {

    }
}
