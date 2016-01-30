
import sun.tools.tree.NewArrayExpression;
import sun.tools.tree.NotEqualExpression;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by johnb on 1/29/16.
 */
public class Hand {
    private ArrayList<Card> hand;

    public Hand() {
        hand = new ArrayList<Card>();
    }

    public void addCard(Card c) {
        this.addCard(c,true);
    }
    public void addCard(Card c, boolean face) {
        hand.add(c);
    }

    public void removeCard(Card c)
    {
        if (hand.contains(c))
        {
            hand.remove(c);
        }
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void deleteHand() {
        hand = new ArrayList<Card>();
    }

    public void sort() {
        Collections.sort(hand, (Card c1,Card c2) -> c1.getNumber() > c2.getNumber() ? -1 : c2.getNumber() > c1.getNumber() ? 1 : 0);
    }

}