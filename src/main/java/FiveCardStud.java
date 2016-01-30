/**
 * Created by nicholaswebb on 1/29/16.
 */
import java.util.*

public class FiveCardStud extends CardGames implements Poker {

    String rankOfHand;
    int roundCount;
    int potSize;
    Deck deck = new Deck();

    ArrayList<Card> playerHand = new ArrayList<Card>();
    ArrayList<Card> npc1Hand = new ArrayList<Card>();
    ArrayList<Card> npc2Hand = new ArrayList<Card>();
    ArrayList<Card> npc3Hand = new ArrayList<Card>();
    ArrayList<Card> npc4Hand = new ArrayList<Card>();

    int minLimit = 10;
    int maxLimit = 100;

    public void setUpGame() {
        deck.shuffle(); //shuffles our deck to begin the game


    }
    public void dealFirstRound(){

    }

    public void dealRemainingRounds(){

    }

    //Takes the rank of the cards and converts it to a string of what they got
    public String rankToString(int rank) {

        switch (rank) {
            case 0:
                rankOfHand = "Nothing";
                break;
            case 1:
                rankOfHand = "Pair";
                break;
            case 2:
                rankOfHand = "Two Pair";
                break;
            case 3:
                rankOfHand = "3 of a Kind";
                break;
            case 4:
                return "Straight";
            break;
            case 5:
                rankOfHand = "Flush";
                break;
            case 6:
                rankOfHand = "Full House";
                break;
            case 7:
                rankOfHand = "4 of a Kind";
                break;
            case 8:
                rankOfHand = "Straight Flush";
                break;
            case 9:
                rankOfHand = "Royal Flush";
                break;
            default:
                rankOfHand = "Error";
        }


    }
}