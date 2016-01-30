import java.util.ArrayList;

abstract public class Game {
    static Player p = new Player();
    private ArrayList<String> playerList;
    private String gameName;
    private int minLimit = 10;
    private int maxLimit = 100;
    private int currentBet;


    public int getCurrentBet() {

        return currentBet;
    }

    public void payOut(int chips) {

        p.addChips(chips);
    }


    public void setCurrentBet(int chips) {
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


}
