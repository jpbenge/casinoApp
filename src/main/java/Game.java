import sun.jvm.hotspot.debugger.posix.elf.ELFSectionHeader;
import sun.jvm.hotspot.ui.SourceCodePanel;
import sun.util.resources.cldr.sr.CalendarData_sr_Cyrl_RS;

import java.util.ArrayList;
import java.util.Scanner;

abstract public class Game {
    Scanner sc = new Scanner(System.in);
    protected ArrayList<Player> playerList;
    protected String gameName;
    protected int minLimit = 10;
    protected int maxLimit = 1000;
    protected int currentBet;


    public void setMinBet(int a) {
        minLimit = a;
    }
    public void setMaxBet(int a) {
        maxLimit = a;
    }

    public int getCurrentBet() {

        return currentBet;
    }

    public void payOut(int chips,Player p) {

        p.addChips(chips);
    }


    protected void setCurrentBet(int chips, Player p) {
        while (chips <minLimit || chips > maxLimit)
        {
            if (chips > p.getChips()) {
                System.out.println("You do not have enough chips to place this bet.");
                System.out.println("Current chips: "+PlayerManager.pc.getChips());
            }
            else if (chips < minLimit)
            {
                System.out.println("This bet is not high enough for this game.");
                System.out.println("Minimum bet: "+minLimit);
            }

            else
            {
                System.out.println("This bet exceeds the limit for this game.");
                System.out.println("Maximum bet: "+maxLimit);
            }
            chips = sc.nextInt();
            sc.nextLine();
        }
        currentBet = chips;
        p.removeChips(currentBet);
    }


    public void start() {

    }

    public void exit() {

    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

}
