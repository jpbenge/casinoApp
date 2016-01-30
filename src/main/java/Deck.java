import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by johnb on 1/29/16.
 */
public class Deck extends ArrayList<Card> {

    public Deck() {
        this(1);
    }

    public Deck(int numDecks){
        for (int i = 0;i<numDecks;i++)
        {
            //Card c = new Card(Suit.HEARTS,1);
            this.add(new Card(Suit.CLUBS,1));
            this.add(new Card(Suit.CLUBS,2));
            this.add(new Card(Suit.CLUBS,3));
            this.add(new Card(Suit.CLUBS,4));
            this.add(new Card(Suit.CLUBS,5));
            this.add(new Card(Suit.CLUBS,6));
            this.add(new Card(Suit.CLUBS,7));
            this.add(new Card(Suit.CLUBS,8));
            this.add(new Card(Suit.CLUBS,9));
            this.add(new Card(Suit.CLUBS,10));
            this.add(new Card(Suit.CLUBS,11));
            this.add(new Card(Suit.CLUBS,12));
            this.add(new Card(Suit.CLUBS,13));
            this.add(new Card(Suit.DIAMONDS,1));
            this.add(new Card(Suit.DIAMONDS,2));
            this.add(new Card(Suit.DIAMONDS,3));
            this.add(new Card(Suit.DIAMONDS,4));
            this.add(new Card(Suit.DIAMONDS,5));
            this.add(new Card(Suit.DIAMONDS,6));
            this.add(new Card(Suit.DIAMONDS,7));
            this.add(new Card(Suit.DIAMONDS,8));
            this.add(new Card(Suit.DIAMONDS,9));
            this.add(new Card(Suit.DIAMONDS,10));
            this.add(new Card(Suit.DIAMONDS,11));
            this.add(new Card(Suit.DIAMONDS,12));
            this.add(new Card(Suit.DIAMONDS,13));
            this.add(new Card(Suit.HEARTS,1));
            this.add(new Card(Suit.HEARTS,2));
            this.add(new Card(Suit.HEARTS,3));
            this.add(new Card(Suit.HEARTS,4));
            this.add(new Card(Suit.HEARTS,5));
            this.add(new Card(Suit.HEARTS,6));
            this.add(new Card(Suit.HEARTS,7));
            this.add(new Card(Suit.HEARTS,8));
            this.add(new Card(Suit.HEARTS,9));
            this.add(new Card(Suit.HEARTS,10));
            this.add(new Card(Suit.HEARTS,11));
            this.add(new Card(Suit.HEARTS,12));
            this.add(new Card(Suit.HEARTS,13));
            this.add(new Card(Suit.SPADES,1));
            this.add(new Card(Suit.SPADES,2));
            this.add(new Card(Suit.SPADES,3));
            this.add(new Card(Suit.SPADES,4));
            this.add(new Card(Suit.SPADES,5));
            this.add(new Card(Suit.SPADES,6));
            this.add(new Card(Suit.SPADES,7));
            this.add(new Card(Suit.SPADES,8));
            this.add(new Card(Suit.SPADES,9));
            this.add(new Card(Suit.SPADES,10));
            this.add(new Card(Suit.SPADES,11));
            this.add(new Card(Suit.SPADES,12));
            this.add(new Card(Suit.SPADES,13));
        }
    }
}
