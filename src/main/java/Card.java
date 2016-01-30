import javax.swing.text.StyledEditorKit;
import java.awt.peer.DialogPeer;

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
    //print out the card by itself
    public void display()
    {
        for (String line : this.getDisplayArray())
        {
            System.out.println(line);
        }
    }
    //Get each line of the ascii art, so that multiple cards can be printed
    //in one line
    public String[] getDisplayArray() {
        String[] display = new String[11];
        if (!faceUp)
        {
            display[0] = " _________   ";
            display[1] = "/         \\  ";
            for (int i = 2;i<10;i++)
            {
                display[i] = "|         |  ";
            }
            display[10] = "\\_________/  ";
            return display;
        }
        String numStr;
        char suitChar;
        String[] suitShape = new String[5];
        //determine what number or letter to show
        switch (number)
        {
            case 1:
                numStr = "A";
                break;
            case 11:
                numStr = "J";
                break;
            case 12:
                numStr = "Q";
                break;
            case 13:
                numStr = "K";
                break;
            default:
                numStr = Integer.toString(number);
                break;
        }
        //determine what symbol to show
        switch (suit)
        {
            case CLUBS:
                suitChar = '\u2663';
                suitShape[0] = "  _  ";
                suitShape[1] = " (_) ";
                suitShape[2] = "(_(_)";
                suitShape[3] = " /_\\ ";
                suitShape[4] = "     ";
                break;
            case DIAMONDS:
                suitChar = '\u2662';
                suitShape[0] = " /\\  ";
                suitShape[1] = "/  \\ ";
                suitShape[2] = "\\  / ";
                suitShape[3] = " \\/  ";
                suitShape[4] = "     ";
                break;
            case HEARTS:
                suitChar = '\u2661';
                suitShape[0] = " _ _ ";
                suitShape[1] = "/ ^ \\";
                suitShape[2] = "\\   /";
                suitShape[3] = " \\ / ";
                suitShape[4] = "  `  ";
                break;
            case SPADES:
                suitChar = '\u2660';
                suitShape[0] = "  ,  ";
                suitShape[1] = " / \\ ";
                suitShape[2] = "(_ _)";
                suitShape[3] = " /_\\ ";
                suitShape[4] = "     ";
                break;
            default:
                suitChar = 'e';
                suitShape[0] = "XXXXXX";
                suitShape[1] = "XXXXXX";
                suitShape[2] = "XXXXXX";
                suitShape[3] = "XXXXXX";
                suitShape[4] = "XXXXXX";
        }
        display[0] = " _________   ";
        display[1] = "/"+suitChar+"        \\  ";
        display[2] = String.format("|%-2s       |  ",numStr);
        display[3] = "|  "+suitShape[0]+"  |  ";
        display[4] = "|  "+suitShape[1]+"  |  ";
        display[5] = "|  "+suitShape[2]+"  |  ";
        display[6] = "|  "+suitShape[3]+"  |  ";
        display[7] = "|  "+suitShape[4]+"  |  ";
        display[8] = "|        "+suitChar+"|  ";
        display[9] = String.format("|       %2s|  ",numStr);
        display[10] = "\\_________/  ";
        return display;
    }
}