import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Comparator;
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
        try {
            BufferedReader br = new BufferedReader(new FileReader(curName+".txt"));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            currentChips = Integer.valueOf(everything.replace("\n",""));
            br.close();
        }
        catch(Exception e) {
            System.out.println(e);
            try {
                PrintWriter writer = new PrintWriter(curName + ".txt", "UTF-8");
                writer.print("1000");
                writer.close();
            } catch (Exception f) {
                File myFile = new File(curName + ".txt");
            }
        }
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

