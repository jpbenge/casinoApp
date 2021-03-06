
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
        c.setFaceUp(face);
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

    public void sort() {

           Collections.sort(hand, (Card c1,Card c2) -> c1.getNumber() > c2.getNumber() ? -1 : c2.getNumber() > c1.getNumber() ? 1 : 0);
    }

    public void display() {
        ArrayList<String[]> cards = new ArrayList<String[]>();
        for(Card card : hand)
        {
            cards.add(card.getDisplayArray());
        }
        for (int i = 0;i<cards.get(0).length;i++)
        {
            for(String[] lines : cards)
            {
                System.out.print(lines[i]);
            }
            System.out.println();
        }
    }
}