import java.util.ArrayList;

abstract public class Game {

    protected ArrayList<Player> playerList;
    protected String gameName;
    protected int minLimit = 10;
    protected int maxLimit = 1000;
    protected int currentBet;


    public int getCurrentBet() {

        return currentBet;
    }

    public void payOut(int chips,Player p) {

        p.addChips(chips);
    }


    public void setCurrentBet(int chips, Player p) {
        if (chips < minLimit) {
            System.out.println("This bet is not high enough for this game.");
        } else if (chips > maxLimit) {
            System.out.println("This bet exceeds the limit for this game.");
        } else if (chips > p.getChips()) {
            System.out.println("You do not have enough chips to place this bet.");
        } else {
            this.currentBet = chips;
            p.removeChips(chips);

        }
    }


    public void start() {

    }

    public void exit() {

    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

}
