import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by johnb on 1/29/16.
 */
public class Deck extends ArrayList<Card> {

    public Deck() {
        this(1);
    }
    //numDecks makes you make a deck comprised of multiple
    //standard decks
    public Deck(int numDecks){
        for (int i = 0;i<numDecks;i++)
        {
            for (int s = 0; s < Suit.values().length;s++)
            {
                for (int n = 1;n<14;n++)
                {
                    this.add(new Card(Suit.values()[s],n));
                }
            }
        }
    }

    public void shuffle()
    {
        Collections.shuffle(this);
    }
}
