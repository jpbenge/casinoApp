import java.util.ArrayList;

abstract public class CardGame extends Game {

    protected int ante = 5;
    protected Player currentTurn;
    protected boolean exit = false;

    //add players to the player list
    protected void initPlayers() {
        playerList = new ArrayList<Player>();
        playerList.add(PlayerManager.pc);
        for (int i = 0; i < 5; i++) {
            Player npc = new Player();
            npc.setNPC(true);
            playerList.add(npc);
        }
    }

}
