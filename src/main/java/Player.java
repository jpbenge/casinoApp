import java.util.HashMap;

 class Player {
    private String name = "Peter";
    private long currentChips = 100;
    private boolean nPC = false;
    //private HashMap gameHistory(String games, int gamesPlayed;


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
    public long getChips() {
        return currentChips;
    }
    public void addChips(long chipsAdd) {
        currentChips +=chipsAdd;
    }
     public void removeChips(long chipsOff) {
         currentChips -= chipsOff;
     }
}

