import java.util.ArrayList;
import java.util.HashMap;

 class Player {
    private String name;
    private long currentChips = 1000;
    private boolean nPC = false;
     private boolean folded = false;
     private ArrayList<Hand> hands;
     private int currentBet;
    //private HashMap gameHistory(String games, int gamesPlayed;
    public Player() {
        hands = new ArrayList<Hand>();
     }

    public String getName() {
        return name;
    }
    public void setName(String curName) {
        name = curName;
    }
    public boolean isNPC() {
        return nPC;
    }
    public void setNPC(boolean pnPC) {
        nPC = pnPC;
    }

     public boolean isFolded() {
         return folded;
     }

     public void setFolded(boolean folded) {
         this.folded = folded;
     }

     public void setCurrentBet(int currentBet) {
         this.currentBet = currentBet;
     }

     public int getCurrentBet() {
         return currentBet;
     }

     public long getChips() {
        return currentChips;
    }
    public void addChips(long chipsAdd) {
        currentChips +=chipsAdd;
    }
     public void removeChips(long chipsOff) {
         currentChips -= chipsOff;
     }
     public ArrayList<Hand> getHands() {
         return hands;
     }

}

