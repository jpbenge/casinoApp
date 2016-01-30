/**
 * Created by johnb on 1/29/16.
 */
public class Card {
    private Suit suit;
    private int number;
    private boolean faceUp;

    public Card(Suit suit, int number) {
        this.suit = suit;
        this.number = number;
        this.faceUp = true;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getNumber() {
        return number;
    }

    public boolean isFaceUp() { return faceUp; }

    public void setFaceUp(boolean f) {
        faceUp = f;
    }
}
