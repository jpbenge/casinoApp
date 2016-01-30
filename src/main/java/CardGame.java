
abstract public class CardGame extends Game {

    //private Deck deck;
    private int ante = 5;
    private int currentBet = getCurrentBet();
    private Player currentTurn;




    private Card deal() {
        return Card c = Deck.get(0);
        Deck.remove(0);


    }

    private void takeAnte() {

        p.removeChips(ante);

    }

}
